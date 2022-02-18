package com.tutorial;

class Mahasiswa{
    String nama;
    String nim;
    String jurusan;

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setNim(String nim){
        this.nim = nim;
    }

    public void setJurursan(String jurusan){
        this.jurusan = jurusan;
    }

    public void PrintAllData(){
        System.out.println(nama);
        System.out.println(nim);
        System.out.println(jurusan);
    }

    String getNama(){
        return this.nama;
    }

    String getNim(){
        return this.nim;
    }

    String getJurusan(){
        return this.jurusan;
    }
}

public class Main {
    public static void main(String[] args) {
        Mahasiswa mahasiswa1 = new Mahasiswa();
        Main myObj = new Main();

        mahasiswa1.setNama("Bachtiar Arya Habibie");
        mahasiswa1.setNim("E41211696");
        mahasiswa1.setJurursan("Teknik Informatika");

        mahasiswa1.PrintAllData();

        myObj.nonStaticMethod();
        
    }

    public void nonStaticMethod(){
        System.out.println("nyobi");
    }
}
