package com.theromus.sha.example;

import static com.theromus.sha.Parameters.KECCAK_224;
import static com.theromus.sha.Parameters.KECCAK_256;
import static com.theromus.sha.Parameters.KECCAK_384;
import static com.theromus.sha.Parameters.KECCAK_512;
import static com.theromus.sha.Parameters.SHA3_224;
import static com.theromus.sha.Parameters.SHA3_256;
import static com.theromus.sha.Parameters.SHA3_384;
import static com.theromus.sha.Parameters.SHA3_512;
import static com.theromus.sha.Parameters.SHAKE128;
import static com.theromus.sha.Parameters.SHAKE256;
import static com.theromus.utils.HexUtils.convertBytesToString;

import java.nio.charset.StandardCharsets;

import com.theromus.exception.CantSetCustomHashLen;
import com.theromus.exception.NotValidHashLenException;
import com.theromus.sha.Keccak;

public class KeccakExamples {

    public static void main(String[] args) {
        byte[] data = "The quick brown fox jumps over the lazy dog".getBytes(StandardCharsets.UTF_8);

        Keccak keccak = new Keccak();
        System.out.println("keccak-224 = " + convertBytesToString(keccak.getHash(data, KECCAK_224)));
        System.out.println("sha3-224 = " + convertBytesToString(keccak.getHash(data, SHA3_224)));
        System.out.println("shake128 = " + convertBytesToString(keccak.getHash(data, SHAKE128)));
        
        // Can use all type of hash in a static way
        System.out.println("keccak-224 = " + convertBytesToString(Keccak.getHash(data, KECCAK_224)));
        System.out.println("keccak-256 = " + convertBytesToString(Keccak.getHash(data, KECCAK_256)));
        System.out.println("keccak-384 = " + convertBytesToString(Keccak.getHash(data, KECCAK_384)));
        System.out.println("keccak-512 = " + convertBytesToString(Keccak.getHash(data, KECCAK_512)));

        System.out.println("sha3-224 = " + convertBytesToString(Keccak.getHash(data, SHA3_224)));
        System.out.println("sha3-256 = " + convertBytesToString(Keccak.getHash(data, SHA3_256)));
        System.out.println("sha3-384 = " + convertBytesToString(Keccak.getHash(data, SHA3_384)));
        System.out.println("sha3-512 = " + convertBytesToString(Keccak.getHash(data, SHA3_512)));

        System.out.println("shake128 = " + convertBytesToString(Keccak.getHash(data, SHAKE128)));
        System.out.println("shake256 = " + convertBytesToString(Keccak.getHash(data, SHAKE256)));
        
        // Can customize length of hash with Shake 
        try {
			System.out.println("shake128 = " + convertBytesToString(Keccak.getHash(data, SHAKE128, 8)));
			System.out.println("shake256 = " + convertBytesToString(Keccak.getHash(data, SHAKE256, 8)));
		} catch (NotValidHashLenException | CantSetCustomHashLen e) {
			e.printStackTrace();
		}

        byte[] data2 = "Some quick brown foxes jumps over the lazy dogs".getBytes(StandardCharsets.UTF_8);

        // With instance you can compute multiple time hash with the same parameter
        keccak = new Keccak(SHAKE128);
        
        System.out.println("shake128 = " + convertBytesToString(keccak.getHash(data)));
        System.out.println("shake128 = " + convertBytesToString(keccak.getHash(data2)));
        
        // Can modify a parameter
        keccak.setHashType(SHA3_384);
        System.out.println("sha3-384 = " + convertBytesToString(keccak.getHash(data)));
        System.out.println("sha3-384 = " + convertBytesToString(keccak.getHash(data2)));
        
        // Can modify a parameter and length
        try {
			keccak.setHashType(SHAKE128, 8);
		} catch (NotValidHashLenException | CantSetCustomHashLen e) {
			e.printStackTrace();
		}
        System.out.println("shake128 = " + convertBytesToString(keccak.getHash(data)));
        
        // Can modify a parameter and length, even separately
        keccak.setHashType(SHAKE256);
        try {
			keccak.setCustomHashLen(8);
		} catch (NotValidHashLenException | CantSetCustomHashLen e) {
			e.printStackTrace();
		}
		System.out.println("shake256 = " + convertBytesToString(keccak.getHash(data)));
        
    }

}
