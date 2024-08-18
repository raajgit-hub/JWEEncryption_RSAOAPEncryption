package com.c1b.negativefile.model;

import java.security.interfaces.ECPublicKey;
import java.util.Map;

import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.lang.JoseException;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;

import org.jose4j.jwk.EllipticCurveJsonWebKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class JWEEncryption {

	/**
	 *
	 * @author RajaKatta
	 */

	String pubKeyStr = "";
	ECPublicKey pubKey = null;

	/*
	 * public JWEEncryption() throws Exception { pubKey =
	 * this.toECPubKey(pubKeyStr); }
	 */

	public static void main(String[] args) throws Exception {
		JWEEncryption et = new JWEEncryption();

		String str = "{ \"key\" : \"Cow jumped over the Moon.\"}";
		System.out.println(0 + ". text = :" + str + ": EncryptedText = :" + et.encrypt(str) + ":");
	}

	/**
	 * This method encrypts a String and returns it.
	 * 
	 * @param str String that needs to be encrypted
	 * @return Encrypted String.
	 * @throws Exception 
	 */
	public String encrypt(String str) throws Exception {
		String encryptedStr = "";
		JsonWebEncryption jwe = new JsonWebEncryption();
		jwe.setPayload(str);
		jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.RSA_OAEP_256);
		jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_256_GCM);

		jwe.setKey(toECPubKey(pubKeyStr));
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
			Map<String, Object> ecParamMap = mapper.readValue(publicKeyJsonStr, new TypeReference<Map<String, Object>>() {});
			ecJsonWebKey = new EllipticCurveJsonWebKey(ecParamMap);
			ecPublicKey = ecJsonWebKey.getECPublicKey();

			if (ecPublicKey == null) {
				System.err.println("Generate EC Public Key :: FAILED, null ec public key");
			} else {
				System.out.println("Generate EC Public Key :: Success");
			}
		} catch (Exception ex) {
			System.err.println("Exception while converting pubKey json to param map :: " + ex.getMessage());
			throw ex;
		}
		return ecPublicKey;
	}
}
