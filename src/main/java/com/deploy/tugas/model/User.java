package com.deploy.tugas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // untuk login
    private String username;
    private String password;

    // untuk data mahasiswa
    private String nim;
    private String nama;
    private int umur;
    private String prodi;
    private String jenisKelamin;
}
