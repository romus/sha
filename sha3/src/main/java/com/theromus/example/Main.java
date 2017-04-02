package com.theromus.example;


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

import java.util.Formatter;

import com.theromus.sha.Keccak;


public class Main {

    public static void main(String[] args) {
        byte[] b = getByteArray("The quick brown fox jumps over the lazy dog");
        String s = getHexStringByByteArray(b);
        Keccak keccak = new Keccak();

        System.out.println("keccak-224 = " + keccak.getHash(s, KECCAK_224));
        System.out.println("keccak-256 = " + keccak.getHash(s, KECCAK_256));
        System.out.println("keccak-384 = " + keccak.getHash(s, KECCAK_384));
        System.out.println("keccak-512 = " + keccak.getHash(s, KECCAK_512));

        System.out.println("sha3-224 = " + keccak.getHash(s, SHA3_224));
        System.out.println("sha3-256 = " + keccak.getHash(s, SHA3_256));
        System.out.println("sha3-384 = " + keccak.getHash(s, SHA3_384));
        System.out.println("sha3-512 = " + keccak.getHash(s, SHA3_512));

        System.out.println("shake128 = " + keccak.getHash(s, SHAKE128));
        System.out.println("shake256 = " + keccak.getHash(s, SHAKE256));
    }

    public static byte[] getByteArray(String s) {
        return (s != null) ? s.getBytes(): null;
    }

    /**
     * Convert the byte array to a hex-string.
     *
     * @param array  byte array
     * @return  hex string
     */
    public static String getHexStringByByteArray(byte[] array) {
        if (array == null)
            return null;

        StringBuilder stringBuilder = new StringBuilder(array.length * 2);
        @SuppressWarnings("resource")
        Formatter formatter = new Formatter(stringBuilder);
        for (byte tempByte : array)
            formatter.format("%02x", tempByte);

        return stringBuilder.toString();
    }

}
