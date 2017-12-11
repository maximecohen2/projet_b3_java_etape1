package fr.epsi.b3;


import java.awt.Toolkit;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

public class QrCode {
	
	public static Image generate(String content, int size) throws WriterException, BadElementException, IOException {
		QRCodeWriter qrWriter = new QRCodeWriter();
		Object matrix = qrWriter.encode(content, BarcodeFormat.QR_CODE, size, size);
		return Image.getInstance(Toolkit.getDefaultToolkit().createImage(MatrixToImageWriter.toBufferedImage((BitMatrix) matrix).getSource()), null);
	}
}
