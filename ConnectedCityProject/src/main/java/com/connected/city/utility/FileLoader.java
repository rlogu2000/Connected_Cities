package com.connected.city.utility;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	public BufferedReader loadFile(final File dataFile) {
		checkFile(dataFile);
		MappedByteBuffer mByteBuffer = loadDataFile(dataFile);
		return getBufferedReader(mByteBuffer);
	}

	protected final MappedByteBuffer loadDataFile(final File dataFile) {
		
		MappedByteBuffer mBytebuffer = null;
		
		try(FileInputStream fInputStream=new FileInputStream(dataFile);FileChannel fChannel=fInputStream.getChannel()) {
			mBytebuffer = fChannel.map(MapMode.READ_ONLY, 0, fChannel.size());
		} catch (FileNotFoundException ex) {
			Terminator.terminate(ex.getMessage(), 1);
		} catch (IOException e) {
			Terminator.terminate(e.getMessage(), 1);
		}
		catch (Exception e) {
			Terminator.terminate(e.getMessage(), 1);
		}
		return mBytebuffer;
	}

	/**
	 * @return {@link BufferedReader} to read through {@link MappedByteBuffer}
	 * */
	protected final BufferedReader getBufferedReader(
			final MappedByteBuffer mByteBuffer) {
		byte[] buffer = new byte[mByteBuffer.limit()];
		mByteBuffer.get(buffer);
		ByteArrayInputStream isr = new ByteArrayInputStream(buffer);
		InputStreamReader ip = new InputStreamReader(isr);
		return new BufferedReader(ip);
	}

	/**
	 * Close file input stream quietly.
	 *
	 * @param fis
	 *            file stream to close.
	 * */
	protected final void closeResource(final FileInputStream fis,
			final FileChannel fChannel) {
		try {
			fis.close();
			fChannel.close();
		} catch (IOException ex) {
			Terminator.terminate(ex.getMessage(), 1);
		}

	}

	/**
	 * Checks if the file exist or not, empty or not. Incase of file doesn't
	 * exist a file doesn't exist will
	 *
	 * @param targetFile
	 *            file to check.
	 * */
	protected final void checkFile(final File file) {
		if (!file.exists()) {
			Terminator.terminate(
					file.getName() + ErrorMsgs.FILE_NOT_FOUND.value(), 1);
		}
		if (file.length() == 0) {
			Terminator.terminate(
					file.getName() + ErrorMsgs.FILE_IS_EMPTY.value(), 1);
		}
	}

}
