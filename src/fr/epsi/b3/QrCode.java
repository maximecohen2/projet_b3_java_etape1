package fr.epsi.b3;

import java.awt.Image;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrCode {
	
	public static Image generate(String content, int size) throws WriterException {
		QRCodeWriter qrWriter = new QRCodeWriter();
		Object matrix = qrWriter.encode(content, BarcodeFormat.QR_CODE, size, size);
		return MatrixToImageWriter.toBufferedImage((BitMatrix) matrix);
	}
}
