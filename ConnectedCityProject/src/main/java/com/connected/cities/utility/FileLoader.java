
package com.connected.cities.utility;

import static com.connected.cities.utility.ErrorMessages.FILE_IS_EMPTY;
import static com.connected.cities.utility.ErrorMessages.FILE_NOT_FOUND;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import static java.nio.channels.FileChannel.MapMode.READ_ONLY;
import java.util.logging.Logger;

/**
 * CustomFileLoader class responsible of loading data file.
 *
 */
public class FileLoader {
	/**
	 * load data file .
	 *
     * @param dataFile
	 * @return {@link BufferedReader} referencing loaded data.
     * @throws java.lang.Exception
	 */
	public BufferedReader loadFile(final File dataFile) throws Exception {
		checkFile(dataFile);
		MappedByteBuffer mByteBuffer = loadDataFile(dataFile);
		return getBufferedReader(mByteBuffer);
	}

    /**
     *
     * @param dataFile
     * @return
     * @throws Exception
     */
    protected MappedByteBuffer loadDataFile(final File dataFile) throws Exception {

		MappedByteBuffer mBytebuffer = null;

		try (FileInputStream fInputStream = new FileInputStream(dataFile);
				FileChannel fChannel = fInputStream.getChannel()) {
			mBytebuffer = fChannel.map(READ_ONLY, 0, fChannel.size());
		} catch (IOException ex) {
			throw ex;
		} catch (Exception e) {
			throw e;
		}
		return mBytebuffer;
	}

	/**
     * @param mByteBuffer
	 * @return {@link BufferedReader} to read through {@link MappedByteBuffer}
     * @throws java.lang.Exception
	 */
	protected BufferedReader getBufferedReader(final MappedByteBuffer mByteBuffer) throws Exception {
		byte[] buffer = new byte[mByteBuffer.limit()];
		mByteBuffer.get(buffer);
		ByteArrayInputStream isr = new ByteArrayInputStream(buffer);
		InputStreamReader ip = new InputStreamReader(isr);
		return new BufferedReader(ip);
	}

	/**
	 * Checks if the file exist or not, empty or not.In case of file doesn't exist a
 file doesn't exist exception is generated
	 *
     * @param file
	
     * @throws java.lang.Exception
	 */
	protected void checkFile(final File file) throws Exception {
		if (!file.exists()) {
			throw new Exception(FILE_NOT_FOUND.toString());
		}
		if (file.length() == 0) {
			throw new Exception(FILE_IS_EMPTY.toString());
		}
	}
    private static final Logger LOG = Logger.getLogger(FileLoader.class.getName());
}
