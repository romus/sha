package com.theromus.sha.example;

import static com.theromus.sha.Parameters.KECCAK_256;
import static com.theromus.sha.Parameters.SHAKE128;
import static com.theromus.utils.HexUtils.convertBytesToString;

import java.nio.charset.StandardCharsets;

import com.theromus.exception.NotValidHashLenException;
import com.theromus.sha.Keccak;

public class KeccakExamples {

    public static void main(String[] args) {
        byte[] data = "The quick brown fox jumps over the lazy dog".getBytes(StandardCharsets.UTF_8);
        byte[] data2 = "Some quick brown foxes jumps over the lazy dogs".getBytes(StandardCharsets.UTF_8);

        // You can insert all type of hash function defined in Parameters
        Keccak keccak = Keccak.getInstance(KECCAK_256);
        
        System.out.println("Keccak-256 = " + convertBytesToString(keccak.getHash(data)));
        System.out.println("Keccak-256 = " + convertBytesToString(keccak.getHash(data2)));
        
        // For SHAKE128 and SHAKE256 you can customize hash length
        try {
			keccak = Keccak.getInstance(SHAKE128, 64);
		} catch (NotValidHashLenException e) {
			e.printStackTrace();
		}
        System.out.println("shake128 = " + convertBytesToString(keccak.getHash(data)));
        System.out.println("shake128 = " + convertBytesToString(keccak.getHash(data2)));
       
        try {
			keccak = Keccak.getInstance(SHAKE128, 60);
		} catch (NotValidHashLenException e) {
			e.printStackTrace();
		}
        System.out.println("shake128 = " + convertBytesToString(keccak.getHash(data)));
        System.out.println("shake128 = " + convertBytesToString(keccak.getHash(data2)));
        
        
    }

}
