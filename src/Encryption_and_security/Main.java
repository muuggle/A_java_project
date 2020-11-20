package Encryption_and_security;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.*;

//public class Main {
//    public static void main(String[] args) {
////        String encoded =URLEncoder.encode("中文！",StandardCharsets.UTF_8);
////        System.out.println(encoded);
//
////        String decoded = URLDecoder.decode("%E4%B8%AD%E6%96%87%21", StandardCharsets.UTF_8);
////        System.out.println(decoded);
//
////        byte[] input=new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad };
////        String b64encoded= Base64.getEncoder().encodeToString(input);
////        System.out.println(b64encoded);
//
////        byte[] output=Base64.getDecoder().decode("5Lit");
////        System.out.println(Arrays.toString(output));
//
////        byte[] input = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad, 0x21};
////        String b64encoded=Base64.getEncoder().encodeToString(input);
////        String b64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input);
////        System.out.println(b64encoded);
////        System.out.println(b64encoded2);
////        byte[] output =Base64.getDecoder().decode(b64encoded2);
////        System.out.println(Arrays.toString(output));
//
//        byte[] input = new byte[] { 0x01, 0x02, 0x7f, 0x00 };
//        String b64encoded = Base64.getUrlEncoder().encodeToString(input);
//        System.out.println(b64encoded);
//        byte[] output = Base64.getUrlDecoder().decode(b64encoded);
//        System.out.println(Arrays.toString(output));
//
//    }
//}

//public class Main{
//    public static void main(String[] args) throws Exception{
//        // 创建一个MessageDigest实例:
//        MessageDigest md =MessageDigest.getInstance("SHA-1");
//        // 反复调用update输入数据:
//        md.update("Hello".getBytes("UTF-8"));
//        md.update("World".getBytes("UTF-8"));
//        byte[] result =md.digest();
//        System.out.println(new BigInteger(1,result).toString(16));
//
//    }
//}

//public class Main{
//    public static void main(String[] args) throws Exception{
//        Security.addProvider(new BouncyCastleProvider());
//        MessageDigest md = MessageDigest.getInstance("RipeMD160");
//        md.update("HelloWorld".getBytes("UTF-8"));
//        byte [] result=md.digest();
//        System.out.println(new BigInteger(1,result).toString(16));
//
//    }
//}

//public class Main {
//    public static void main(String[] args) throws Exception{
////        KeyGenerator keyGen=KeyGenerator.getInstance("HmacMD5");
////        SecretKey key=keyGen.generateKey();
////        // 打印随机生成的key:
////        byte[] skey= key.getEncoded();
////        System.out.println(new BigInteger(1,skey).toString(16));
////        Mac mac= Mac.getInstance("HmacMD5");
////        mac.init(key);
////        mac.update("HelloWorld".getBytes("UTF-8"));
////        byte[] result=mac.doFinal();
////        System.out.println(new BigInteger(1,result).toString(16));
//        byte[] hkey = new byte[] { 106, 70, -110, 125, 39, -20, 52, 56, 85, 9, -19, -72, 52, -53, 52, -45, -6, 119, -63,
//                30, 20, -83, -28, 77, 98, 109, -32, -76, 121, -106, 0, -74, -107, -114, -45, 104, -104, -8, 2, 121, 6,
//                97, -18, -13, -63, -30, -125, -103, -80, -46, 113, -14, 68, 32, -46, 101, -116, -104, -81, -108, 122,
//                89, -106, -109 };
//
//        SecretKey key=new SecretKeySpec(hkey,"HmacMD5");
//        Mac mac=Mac.getInstance("HmacMD5");
//        mac.init(key);
//        mac.update("HelloWorld".getBytes("Utf-8"));
//        byte[] result=mac.doFinal();
//        System.out.println(Arrays.toString(result));
//
//    }
//}

//public class Main {
//    public static void main(String[] args) throws Exception {
//        // 原文:
//        String message = "hello zxn";
//        System.out.println("Message:" + message);
//        // 128位密钥 = 16 bytes Key:
//        byte[] key = "1234567890abcdef".getBytes("UTF-8");
//        // 加密:
//        byte[] data = message.getBytes("UTF-8");
//        byte[] encrypted = encrypt(key, data);
//        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
//        // 解密:
//        byte[] decrypted = decrypt(key, encrypted);
//        System.out.println("Decrypted: " + new String(decrypted, "UTF-8"));
//    }
//
//    //加密
//    public static byte[] encrypt(byte[] key, byte[] input) throws GeneralSecurityException {
//        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//        SecretKey keySpec = new SecretKeySpec(key, "AES");
//        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
//        return cipher.doFinal(input);
//
//    }
//
//    public static byte[] decrypt(byte[] key, byte[] input) throws GeneralSecurityException {
//        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//        SecretKey keySpec = new SecretKeySpec(key, "AES");
//        cipher.init(Cipher.DECRYPT_MODE, keySpec);
//        return cipher.doFinal(input);
//    }
//}

//public class Main {
//    public static void main(String[] args) throws Exception {
//        Security.addProvider(new BouncyCastleProvider());
//        String message = "Hello, world!";
//        String password = "hello12345";
//        byte[] salt = SecureRandom.getInstanceStrong().generateSeed(16);
//        System.out.printf("salt: %032x\n", new BigInteger(1, salt));
//
//        byte[] data = message.getBytes("UTF-8");
//        byte[] encrypted = encrypt(password, salt, data);
//        System.out.println("encrypted: " + Base64.getEncoder().encodeToString(encrypted));
//
//        byte[] decrypted = decrypt(password, salt, encrypted);
//        System.out.println("decrypted: " + new String(decrypted, "UTF-8"));
//
//
//    }
//
//    // 加密:
//    public static byte[] encrypt(String password, byte[] salt, byte[] input) throws GeneralSecurityException {
//        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
//        SecretKeyFactory skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
//        SecretKey skey = skeyFactory.generateSecret(keySpec);
//        PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
//        Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
//        cipher.init(Cipher.ENCRYPT_MODE, skey, pbeps);
//        return cipher.doFinal(input);
//    }
//
//    // 解密:
//    public static byte[] decrypt(String password, byte[] salt, byte[] input) throws GeneralSecurityException {
//        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
//        SecretKeyFactory skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
//        SecretKey skey = skeyFactory.generateSecret(keySpec);
//        PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
//        Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
//        cipher.init(Cipher.DECRYPT_MODE, skey, pbeps);
//        return cipher.doFinal(input);
//    }
//}
////使用Java实现DH算法的代码如下：
//public class Main {
//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        Person bob = new Person("Bob");
//        Person alice = new Person("Alice");
//
//        // 各自生成KeyPair:
//        bob.generateKeyPair();
//        alice.generateKeyPair();
//
//        // 双方交换各自的PublicKey:
//        // Bob根据Alice的PublicKey生成自己的本地密钥:
//        bob.generateSecretKey(alice.publicKey.getEncoded());
//        alice.generateSecretKey(bob.publicKey.getEncoded());
//
//        // 检查双方的本地密钥是否相同:
//        bob.printKeys();
//        alice.printKeys();
//        // 双方的SecretKey相同，后续通信将使用SecretKey作为密钥进行AES加解密...
//    }
//}
//
//class Person {
//    public final String name;
//
//    public PublicKey publicKey;
//    private PrivateKey privateKey;
//    private byte[] secretKey;
//
//    public Person(String name) {
//        this.name = name;
//    }
//
//    public void generateKeyPair() throws NoSuchAlgorithmException {
//        try {
//            KeyPairGenerator kpGen = KeyPairGenerator.getInstance("DH");
//            kpGen.initialize(512);
//            KeyPair kp = kpGen.generateKeyPair();
//            this.privateKey = kp.getPrivate();
//            this.publicKey = kp.getPublic();
//        } catch (GeneralSecurityException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void generateSecretKey(byte[] receivedPubKeyBytes) {
//        try {
//            // 从byte[]恢复PublicKey:
//            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(receivedPubKeyBytes);
//            KeyFactory kf = KeyFactory.getInstance("DH");
//            PublicKey receivePublicKey = kf.generatePublic(keySpec);
//            // 生成本地密钥:
//            KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
//            keyAgreement.init(this.privateKey);// 自己的PrivateKey
//            keyAgreement.doPhase(receivePublicKey, true);// 对方的PublicKey
//            // 生成SecretKey密钥:
//            this.secretKey = keyAgreement.generateSecret();
//        } catch (GeneralSecurityException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void printKeys() {
//        System.out.printf("Name:%s\n",this.name);
//        System.out.printf("Private key: %x\n", new BigInteger(1, this.privateKey.getEncoded()));
//        System.out.printf("Public key: %x\n", new BigInteger(1, this.publicKey.getEncoded()));
//        System.out.printf("Secret key: %x\n", new BigInteger(1, this.secretKey));
//    }
//}

//public class Main{
//    public static void main(String[] args) throws Exception{
//        //明文
//        byte[] plain="Hello, encrypt use RSA".getBytes(StandardCharsets.UTF_8);
//        //创建公钥、私钥对
//        Person alice=new Person("Alice");
//        // 用Alice的公钥加密:
//        byte[] pk= alice.getPublickey();
//        System.out.printf("public key: %x%n", new BigInteger(1, pk));
//        byte[] encrypted=alice.encrypt(plain);
//        System.out.printf("encrypted: %x%n", new BigInteger(1, encrypted));
//        // 用Alice的私钥解密:
//        byte[] sk=alice.getPrivateKey();
//        System.out.printf("private key: %x%n", new BigInteger(1, sk));
//        byte[] decrypted= alice.decrypt(encrypted);
//        System.out.println(new String(decrypted, StandardCharsets.UTF_8));
//    }
//}
//public class Main {
//    public static void main(String[] args) throws GeneralSecurityException {
//        // 生成RSA公钥/私钥:
//        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
//        kpGen.initialize(1024);
//        KeyPair kp = kpGen.generateKeyPair();
//        PrivateKey sk = kp.getPrivate();
//        PublicKey pk = kp.getPublic();
//
//        // 待签名的消息:
//        byte[] message="Hello, I am Bob!".getBytes(StandardCharsets.UTF_8);
//
//        //用私钥签名:
//        Signature s=Signature.getInstance("SHA1withRSA");
//        s.initSign(sk);
//        s.update(message);
//        byte[] signed=s.sign();
//        System.out.printf("signature: %x", new BigInteger(1, signed));
//
//        // 用公钥验证:
//        Signature v=Signature.getInstance("SHA1withRSA");
//        v.initVerify(pk);
//        v.update(message);
//        boolean valid=v.verify(signed);
//         System.out.println("valid? " + valid);
//    }
//}

