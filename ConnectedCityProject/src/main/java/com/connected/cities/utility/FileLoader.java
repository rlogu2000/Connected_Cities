package com.connected.cities.utility;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * CustomFileLoader class responsible of loading data file.
 *
 * */
public class FileLoader {
	/**
	 * load data file .
	 *
	 * @param filePath
	 *            data file path.
	 * @return {@link BufferedReader} referencing loaded data.
	 * */
	public BufferedReader loadFile(final File dataFile)throws Exception {
		checkFile(dataFile);
		MappedByteBuffer mByteBuffer = loadDataFile(dataFile);
		return getBufferedReader(mByteBuffer);
	}

	protected final MappedByteBuffer loadDataFile(final File dataFile)throws Exception {
		
		MappedByteBuffer mBytebuffer = null;
		
		try(FileInputStream fInputStream=new FileInputStream(dataFile);FileChannel fChannel=fInputStream.getChannel()) {
			mBytebuffer = fChannel.map(MapMode.READ_ONLY, 0, fChannel.size());
		} catch (IOException ex) {
			throw ex;
		}
		catch (Exception e) {
			throw e;
		}
		return mBytebuffer;
	}

	/**
	 * @return {@link BufferedReader} to read through {@link MappedByteBuffer}
	 * */
	protected final BufferedReader getBufferedReader(final MappedByteBuffer mByteBuffer)throws Exception {
		byte[] buffer = new byte[mByteBuffer.limit()];
		mByteBuffer.get(buffer);
		ByteArrayInputStream isr = new ByteArrayInputStream(buffer);
		InputStreamReader ip = new InputStreamReader(isr);
		return new BufferedReader(ip);
	}

	/**
	 * Checks if the file exist or not, empty or not. Incase of file doesn't
	 * exist a file doesn't exist will
	 *
	 * @param targetFile
	 *            file to check.
	 * */
	protected final void checkFile(final File file)throws Exception {
		if (!file.exists()) {
			throw new Exception(ErrorMessages.FILE_NOT_FOUND.toString());
		}	
		if (file.length() == 0) {
			throw new Exception(ErrorMessages.FILE_IS_EMPTY.toString());
		}
	 }
}
