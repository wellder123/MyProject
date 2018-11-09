package com.chang.test.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.Cipher;

//import org.apache.commons.codec.binary.Hex;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class CertificateTest {

	private static final String PRIVATE_NAME = "Lg_ServerPrivate_key_2018.der";
    private static final String CERTIFICATE_NAME = "Lg_cert_2018.der";
    private static String certificatePath;
    private static String privatePath;
    final static BASE64Encoder encoder = new BASE64Encoder();
    final static BASE64Decoder decoder = new BASE64Decoder();
    
    private static String src = "世界你好！";
    
	static {
        String currentDir = CertificateTest.class.getResource("").getPath();
        if (currentDir.startsWith("/"))
            currentDir = currentDir.substring(1);
        if (!currentDir.endsWith("/")) 
            currentDir += "/";
        privatePath = currentDir + PRIVATE_NAME;
        certificatePath = currentDir + CERTIFICATE_NAME;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        DerTest();
	}

	public static void DerTest()  {
		
		PrivateKey privateKey = null;
		PublicKey publicKey= geneneratePublicKey(certificatePath);
		Cipher cipher = null;
		byte[] encryptResult =null;
		byte[] signResult =null;
		Signature signature = null;
		
		try {
			privateKey = generatePrivateKey(getContent(privatePath));
			cipher = Cipher.getInstance("RSA");
			signature = Signature.getInstance("MD5withRSA");
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
		
		//私钥签名
		try {
			
			signature.initSign(privateKey);
			signature.update(src.getBytes());
			signResult = signature.sign();
			//System.out.println("私钥签名: " + Hex.encodeHexString(signResult));
			System.out.println("私钥签名Base64:" + encoder.encode(signResult).replaceAll("\r\n", ""));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//公钥验签
		try {
			// 构建签名
	        signature.initVerify(publicKey);
	        signature.update(src.getBytes());
	        Boolean  verify =signature.verify(signResult);
	        System.out.println("公钥验签结果:"+verify);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		//公钥加密
		try {
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            encryptResult = cipher.doFinal(src.getBytes());
            System.out.println("=================================");
            //System.out.println("公钥加密 : "+Hex.encodeHexString(encryptResult));
            System.out.println("公钥加密 Base64格式: "+encoder.encode(encryptResult).replaceAll("\r\n", ""));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//私钥解密
		try {
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            
            byte[] decryptedData=cipher.doFinal(encryptResult);
            
            System.out.println("私钥解密后的数据: "+new String(decryptedData)); 
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		//私钥加密
		try {
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            encryptResult = cipher.doFinal(src.getBytes());
            System.out.println("=================================");
            //System.out.println("私钥加密 : "+Hex.encodeHexString(encryptResult));
            System.out.println("私钥加密 Base64格式: "+encoder.encode(encryptResult).replaceAll("\r\n", ""));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//公钥解密
		try {
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            
            byte[] decryptedData=cipher.doFinal(encryptResult);
            
            System.out.println("公钥解密后的数据: "+new String(decryptedData)); 
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static PrivateKey generatePrivateKey(byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException {
		KeySpec keySpec = new PKCS8EncodedKeySpec(key);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePrivate(keySpec);
	}
	
	public static PublicKey geneneratePublicKey(String certificatePath) {  

			CertificateFactory certificateFactory;
			PublicKey publicKey = null;
			try {
				certificateFactory = CertificateFactory.getInstance("X.509");
				FileInputStream in = new FileInputStream(certificatePath);
		        Certificate certificate = certificateFactory.generateCertificate(in);
		        in.close();
		        publicKey = certificate.getPublicKey();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
         return publicKey;
		}  
	
	@SuppressWarnings("resource")
	public static byte[] getContent(String filePath) throws IOException {

        File file = new File(filePath);
        long fileSize = file.length();

        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }

        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;

        while (offset < buffer.length
             && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }

        // 确保所有数据均被读取
        if (offset != buffer.length) {
	        throw new IOException("Could not completely read file "
	                + file.getName());
        }

        fi.close();

        return buffer;

    }
}
