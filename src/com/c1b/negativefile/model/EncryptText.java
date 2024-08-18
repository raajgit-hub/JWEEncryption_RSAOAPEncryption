package com.c1b.negativefile.model;

import java.security.interfaces.ECPublicKey;
import java.util.Map;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.jwk.EllipticCurveJsonWebKey;
import org.jose4j.lang.JoseException;

/**
 *
 * @author VivekGupta
 */
public class EncryptText {
	
	  String pubKeyStr = " {\n" + " \"kty\": \"EC\",\n" +
	  " \"toexp\": 1579128403,\n" + " \"use\": \"enc\",\n" +
	  " \"crv\": \"P-256\",\n" + " \"kid\": \"ECIamJwkKeySet\",\n" +
	  " \"x\": \"6mEaEM9ICmjqe4B88Hq65xdOM76MOp9zvnH9SifMMks\",\n" +
	  " \"y\": \"89gAIub27A2Xq-c0AazECjltstxgkm9gcSy-XHdIp8A\",\n" +
	  " \"toc\": 1579128463,\n" + " \"alg\": \"P-256\",\n" +
	  " \"tid\": \"t99cyte9hk\"\n" + " }";
	 
	/*
	 * String pubKeyStr = "{\r\n" + "	\"typ\":\"jwt\",\r\n" +
	 * "	\"enc\":\"A256GCM\",\r\n" + "	\"alg\":\"RSA-OAEP-256\",\r\n" +
	 * "	\"crv\":\"RSA-OAEP-256\",\r\n" +
	 * "	\"kid\":\"-----BEGIN CERTIFICATE-----" +
	 * "MIIFUjCCBDqgAwIBAgIQClAmUjddMZRNdWYg3whJUTANBgkqhkiG9w0BAQsFADBR" +
	 * "MQswCQYDVQQGEwJVUzEWMBQGA1UEChMNRGlnaUNlcnQgSW5jLjEqMCgGA1UEAxMh" +
	 * "RGlnaUNlcnQgUHJpdmF0ZSBTU0wgU0hBMSBDQSAtIEcyMB4XDTIyMDkwODAwMDAw" +
	 * "MFoXDTI1MDkxMDIzNTk1OVowejELMAkGA1UEBhMCVVMxDzANBgNVBAgTBk5ldmFk" +
	 * "YTESMBAGA1UEBxMJTGFzIFZlZ2FzMR4wHAYDVQQKExVDcmVkaXQgT25lIEJhbmss" +
	 * "IE4uQS4xJjAkBgNVBAMTHWFwaS1qd2Uubm9ucHJvZC5jcmVkaXRvbmUuY29tMIIB" +
	 * "IjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsN05O37170btZgpirR6JlcKj" +
	 * "IoAFJ6WA74PK9Ks2DqzQ8EakSK+5FP9UA0OI9VqbjvwTWBUcjQW5Cwt/ZtIhgx3Z" +
	 * "tpOWMiZbi0+qO3RyFXfedX/nfmvOZ4BA62pKgV8z0POJDa5XWIHmhPZrrTmjFLn7" +
	 * "CHVsNKAn3OkP8C//JAVw+Dh94i4JKRIWuvPuYxtSVFJVbuhXU32v6qDz65f0JL/0" +
	 * "mvNXlASo5lKAsB+YTkNrVYwruegZBQdamfAwo6NHIyBEBMlZ2+k8W/h9n1wgO6Vg" +
	 * "RRpqvmc8ossUU8OMCroTp1mGoOZr/Sla/cc7HoXbximNFWCJiX2dfeuErn/HCQID" +
	 * "AQABo4IB+zCCAfcwHwYDVR0jBBgwFoAU5ER5NPZCxMOtCMsu3TOLux9XlBIwHQYD" +
	 * "VR0OBBYEFAeldAuRsrxheNRIaIkpmH9bnlMZMCgGA1UdEQQhMB+CHWFwaS1qd2Uu" +
	 * "bm9ucHJvZC5jcmVkaXRvbmUuY29tMA4GA1UdDwEB/wQEAwIFoDAdBgNVHSUEFjAU" +
	 * "BggrBgEFBQcDAQYIKwYBBQUHAwIwgYsGA1UdHwSBgzCBgDA+oDygOoY4aHR0cDov" +
	 * "L2NybDMuZGlnaWNlcnQuY29tL0RpZ2lDZXJ0UHJpdmF0ZVNTTFNIQTFDQS1HMi5j" +
	 * "cmwwPqA8oDqGOGh0dHA6Ly9jcmw0LmRpZ2ljZXJ0LmNvbS9EaWdpQ2VydFByaXZh" +
	 * "dGVTU0xTSEExQ0EtRzIuY3JsMEEGA1UdIAQ6MDgwNgYJYIZIAYb9bAEBMCkwJwYI" +
	 * "KwYBBQUHAgEWG2h0dHA6Ly93d3cuZGlnaWNlcnQuY29tL0NQUzB9BggrBgEFBQcB" +
	 * "AQRxMG8wJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLmRpZ2ljZXJ0LmNvbTBHBggr" +
	 * "BgEFBQcwAoY7aHR0cDovL2NhY2VydHMuZGlnaWNlcnQuY29tL0RpZ2lDZXJ0UHJp" +
	 * "dmF0ZVNTTFNIQTFDQS1HMi5jcnQwDAYDVR0TAQH/BAIwADANBgkqhkiG9w0BAQsF" +
	 * "AAOCAQEAg4iQ/58GRzyur3lQtl1rkftCcU2O+Uud2AVhSXHs3GV+MDRn/Wt3rRtd" +
	 * "+Bn/qvJl5QkHV7+pOZFtXjIYCQWVGTLOC2COxnBEGQYIjcJHOhXz4Pg6T7inHenp" +
	 * "WJtNuxMGOHMYHOBX3a13xE5cLPvxKhSEfDd/e7cFBGw6NNKvHFQeGqBl0nmkMRAh" +
	 * "J3ocnOIFoDXDxWTDyW5ZzWCQ/eLRaA57UoSMXuBJxxHxayIzsx9NUUoKJ1MUbtrd" +
	 * "C6k1vr56+rOJEhF4QdtPMTVKAJ97JzwCxRgaoTxEFN+Pm80OVow8Lj1jg4gwwEey" +
	 * "DOcOtma3i2Z/N63ffsfwjL4mL8YiXw==" + "-----END CERTIFICATE-----\"" + "}";
	 */
	ECPublicKey pubKey = null;

	public EncryptText() throws Exception {

		pubKey = this.toECPubKey(pubKeyStr);
		/*pubKey = this.toECPubKey(
				"-----BEGIN CERTIFICATE-----" + "MIIFUjCCBDqgAwIBAgIQClAmUjddMZRNdWYg3whJUTANBgkqhkiG9w0BAQsFADBR"
						+ "MQswCQYDVQQGEwJVUzEWMBQGA1UEChMNRGlnaUNlcnQgSW5jLjEqMCgGA1UEAxMh"
						+ "RGlnaUNlcnQgUHJpdmF0ZSBTU0wgU0hBMSBDQSAtIEcyMB4XDTIyMDkwODAwMDAw"
						+ "MFoXDTI1MDkxMDIzNTk1OVowejELMAkGA1UEBhMCVVMxDzANBgNVBAgTBk5ldmFk"
						+ "YTESMBAGA1UEBxMJTGFzIFZlZ2FzMR4wHAYDVQQKExVDcmVkaXQgT25lIEJhbmss"
						+ "IE4uQS4xJjAkBgNVBAMTHWFwaS1qd2Uubm9ucHJvZC5jcmVkaXRvbmUuY29tMIIB"
						+ "IjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsN05O37170btZgpirR6JlcKj"
						+ "IoAFJ6WA74PK9Ks2DqzQ8EakSK+5FP9UA0OI9VqbjvwTWBUcjQW5Cwt/ZtIhgx3Z"
						+ "tpOWMiZbi0+qO3RyFXfedX/nfmvOZ4BA62pKgV8z0POJDa5XWIHmhPZrrTmjFLn7"
						+ "CHVsNKAn3OkP8C//JAVw+Dh94i4JKRIWuvPuYxtSVFJVbuhXU32v6qDz65f0JL/0"
						+ "mvNXlASo5lKAsB+YTkNrVYwruegZBQdamfAwo6NHIyBEBMlZ2+k8W/h9n1wgO6Vg"
						+ "RRpqvmc8ossUU8OMCroTp1mGoOZr/Sla/cc7HoXbximNFWCJiX2dfeuErn/HCQID"
						+ "AQABo4IB+zCCAfcwHwYDVR0jBBgwFoAU5ER5NPZCxMOtCMsu3TOLux9XlBIwHQYD"
						+ "VR0OBBYEFAeldAuRsrxheNRIaIkpmH9bnlMZMCgGA1UdEQQhMB+CHWFwaS1qd2Uu"
						+ "bm9ucHJvZC5jcmVkaXRvbmUuY29tMA4GA1UdDwEB/wQEAwIFoDAdBgNVHSUEFjAU"
						+ "BggrBgEFBQcDAQYIKwYBBQUHAwIwgYsGA1UdHwSBgzCBgDA+oDygOoY4aHR0cDov"
						+ "L2NybDMuZGlnaWNlcnQuY29tL0RpZ2lDZXJ0UHJpdmF0ZVNTTFNIQTFDQS1HMi5j"
						+ "cmwwPqA8oDqGOGh0dHA6Ly9jcmw0LmRpZ2ljZXJ0LmNvbS9EaWdpQ2VydFByaXZh"
						+ "dGVTU0xTSEExQ0EtRzIuY3JsMEEGA1UdIAQ6MDgwNgYJYIZIAYb9bAEBMCkwJwYI"
						+ "KwYBBQUHAgEWG2h0dHA6Ly93d3cuZGlnaWNlcnQuY29tL0NQUzB9BggrBgEFBQcB"
						+ "AQRxMG8wJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLmRpZ2ljZXJ0LmNvbTBHBggr"
						+ "BgEFBQcwAoY7aHR0cDovL2NhY2VydHMuZGlnaWNlcnQuY29tL0RpZ2lDZXJ0UHJp"
						+ "dmF0ZVNTTFNIQTFDQS1HMi5jcnQwDAYDVR0TAQH/BAIwADANBgkqhkiG9w0BAQsF"
						+ "AAOCAQEAg4iQ/58GRzyur3lQtl1rkftCcU2O+Uud2AVhSXHs3GV+MDRn/Wt3rRtd"
						+ "+Bn/qvJl5QkHV7+pOZFtXjIYCQWVGTLOC2COxnBEGQYIjcJHOhXz4Pg6T7inHenp"
						+ "WJtNuxMGOHMYHOBX3a13xE5cLPvxKhSEfDd/e7cFBGw6NNKvHFQeGqBl0nmkMRAh"
						+ "J3ocnOIFoDXDxWTDyW5ZzWCQ/eLRaA57UoSMXuBJxxHxayIzsx9NUUoKJ1MUbtrd"
						+ "C6k1vr56+rOJEhF4QdtPMTVKAJ97JzwCxRgaoTxEFN+Pm80OVow8Lj1jg4gwwEey"
						+ "DOcOtma3i2Z/N63ffsfwjL4mL8YiXw==" + "-----END CERTIFICATE-----");*/
	}

	public static void main(String[] args) throws Exception {
		EncryptText et = new EncryptText();
		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				System.out.println(i + ". text = " + args[i] + " EncryptedText = " + et.encrypt(args[i]));
			}
		} else {
			String str = "Cow jumped over the Moon.";
			System.out.println(0 + ". text = :" + str + ": EncryptedText = :" + et.encrypt(str) + ":");
		}
	}

	/**
	 * This method encrypts a String and returns it.
	 * 
	 * @param str String that needs to be encrypted
	 * @return Encrypted String.
	 * @throws JoseException
	 */
	public String encrypt(String str) throws JoseException {
		String encryptedStr = "";
		JsonWebEncryption jwe = new JsonWebEncryption();
		jwe.setPayload(str);
		jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.RSA_OAEP_256);
		jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_256_GCM);
		jwe.setKey(pubKey);
		encryptedStr = jwe.getCompactSerialization();
		return encryptedStr;

	}

	/**
	 * This method takes the public Key in JWK format and converts it into
	 * ECPublicKey
	 * 
	 * @param publicKeyJsonStr ECPublic Key JSON String.
	 * @return
	 * @throws Exception
	 */
	private ECPublicKey toECPubKey(String publicKeyJsonStr) throws Exception {
		ECPublicKey ecPublicKey = null;
		EllipticCurveJsonWebKey ecJsonWebKey = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, Object> ecParamMap = mapper.readValue(publicKeyJsonStr,
					new TypeReference<Map<String, Object>>() {
					});
			ecJsonWebKey = new EllipticCurveJsonWebKey(ecParamMap);
			ecPublicKey = ecJsonWebKey.getECPublicKey();

			if (ecPublicKey == null) {
				System.err.println("Generate EC Public Key :: FAILED, null ec public key");
			} else {
				System.out.println("Generate EC Public Key :: Success");
			}
		} catch (JsonParseException | JsonMappingException | JoseException ex) {
			System.err.println("Exception while converting pubKey json to param map :: " + ex.getMessage());
			throw ex;
		}
		return ecPublicKey;
	}
}