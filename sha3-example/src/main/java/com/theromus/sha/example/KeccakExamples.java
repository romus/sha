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

import com.theromus.sha.Keccak;

public class KeccakExamples {

    public static void main(String[] args) {
        byte[] data = "The quick brown fox jumps over the lazy dog".getBytes(StandardCharsets.UTF_8);

        Keccak keccak = new Keccak();

        System.out.println("keccak-224 = " + convertBytesToString(keccak.getHash(data, KECCAK_224)));
        System.out.println("keccak-256 = " + convertBytesToString(keccak.getHash(data, KECCAK_256)));
        System.out.println("keccak-384 = " + convertBytesToString(keccak.getHash(data, KECCAK_384)));
        System.out.println("keccak-512 = " + convertBytesToString(keccak.getHash(data, KECCAK_512)));

        System.out.println("sha3-224 = " + convertBytesToString(keccak.getHash(data, SHA3_224)));
        System.out.println("sha3-256 = " + convertBytesToString(keccak.getHash(data, SHA3_256)));
        System.out.println("sha3-384 = " + convertBytesToString(keccak.getHash(data, SHA3_384)));
        System.out.println("sha3-512 = " + convertBytesToString(keccak.getHash(data, SHA3_512)));

        System.out.println("shake128 = " + convertBytesToString(keccak.getHash(data, SHAKE128)));
        System.out.println("shake256 = " + convertBytesToString(keccak.getHash(data, SHAKE256)));
    }

}
