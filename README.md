Modul6_ArsitekturAplikasiAndroid
Nama: Charisa Salsabila Larasati
NIM: 24515020111022
Deskripsi: Tugas praktikum Pengembangan Aplikasi Perangkat Bergerak (PAPB) mengenai Arsitektur Aplikasi Android (UI Layer, ViewModel, Repository, & Data Layer)

Proyek ini merupakan pengembangan lanjutan dari NavigationLab yang menerapkan prinsip Clean Architecture dan Separation of Concerns pada pengembangan aplikasi Android berbasis Jetpack Compose. Fokus utamanya adalah memisahkan tanggung jawab secara tegas, di mana komponen antarmuka seperti HomeScreen dan DetailScreen hanya bertugas merender state dan menangani interaksi pengguna, sementara logika pengelolaan data didelegasikan sepenuhnya ke ViewModel melalui kontrak antarmuka Repository yang mengabstraksi sumber data lokal in-memory (StudentLocalDataSource).

Dalam pengembangannya, aplikasi ini dibangun secara bertahap mulai dari penataan struktur package berlapis, pembuatan model data Student, perancangan repository dengan antarmuka yang bersih, hingga penyusunan UI state dan ViewModel tingkat layar yang aman terhadap perubahan konfigurasi perangkat seperti rotasi layar. Selain itu, integrasi navigasi multi-layar dari Home ke Detail menggunakan argumen studentId dipastikan berjalan mulus bersamaan dengan fungsionalitas tombol Back, Profile, dan About.

Sebagai bagian dari pengembangan fitur utama, daftar mahasiswa pada halaman Home dirancang secara interaktif menggunakan komponen LazyColumn dengan penambahan data baru serta implementasi penanganan state error khusus untuk skenario ketika data yang dicari tidak ditemukan.
