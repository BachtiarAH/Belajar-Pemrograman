package com.tutorial;

class Mahasiswa{
    String nama;
    String nim;
    String jurusan;

    //construktor
    Mahasiswa(String inputNama, String inputNim, String inputJurusan){
        nama = inputNama;
        nim = inputNim;
        jurusan = inputJurusan;

        System.out.println(nama);
        System.out.println(nim);
        System.out.println(jurusan);
    }
}

class main{
    public static void main(String[] args) {
        Mahasiswa mahasiswa1 = new Mahasiswa("Bachtiar Arya Habibie", "E41211696", "Teknologi Informasi");       
    }
}