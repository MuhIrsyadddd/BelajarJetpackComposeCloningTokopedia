package com.gunder.market.model // // Ini adalah "alamat" atau folder tempat file Kotlin ini berada.

// // Perintah ini SANGAT PENTING.
// // Ini "mengimpor" file `R.kt` (R untuk Resource) yang otomatis dibuat Android.
// // File `R.kt` berisi ID (angka/Integer) untuk semua resource Anda
// // (seperti gambar di folder `drawable` dan teks di file `strings.xml`).
import com.gunder.market.R

// // 'data class' adalah jenis kelas khusus di Kotlin yang
// // tujuannya HANYA untuk "menyimpan data".
// // 'ListTopMenu' adalah nama "cetakan" atau "blueprint" yang kita buat.
data class ListTopMenu(
    // // Properti pertama. 'val' berarti read-only (tidak bisa diubah).
    // // Tipenya 'Int' (Integer), BUKAN 'String' atau 'Image'.
    // // Kenapa 'Int'? Karena 'R.drawable.gopay' adalah sebuah ID (angka/Integer).
    val imgTopBar: Int,

    // // Properti kedua, juga 'Int'.
    // // Ini akan menyimpan ID resource string, seperti 'R.string.txt_gopay'.
    val txtTopBar: Int,

    // // Properti ketiga, juga 'Int' untuk ID resource string deskripsi.
    val descTopBar: Int
)

// // Di sini kita membuat sebuah 'List' (daftar) berisi data 'dummy' (contoh)
// // untuk ditampilkan di UI. 'val' berarti daftar ini tidak bisa diubah.
// // 'listOf(...)' adalah fungsi Kotlin untuk membuat daftar.
val dummyListTopMenus = listOf(
    // // Ini adalah OBJEK pertama di dalam daftar.
    // // Kita membuat objek nyata menggunakan "cetakan" 'ListTopMenu'
    // // dan mengisinya dengan ID resource yang sebenarnya.
    ListTopMenu(R.drawable.gopay, R.string.txt_gopay, R.string.txt_dummy_gopay),

    // // Ini OBJEK kedua di dalam daftar.
    ListTopMenu(R.drawable.plus, R.string.txt_dummy_discount, R.string.txt_subscription),

    // // Ini OBJEK ketiga di dalam daftar.
    ListTopMenu(R.drawable.rewards, R.string.txt_rewards, R.string.txt_dummy_rewards)
)