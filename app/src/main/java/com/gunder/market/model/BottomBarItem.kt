package com.gunder.market.model // // "Alamat" paket (folder) tempat file ini disimpan.

// // Impor ini PENTING.
// // 'ImageVector' adalah kelas (class) yang digunakan Jetpack Compose
// // untuk merepresentasikan ikon vektor (seperti ikon dari 'Icons.Default.Home').
import androidx.compose.ui.graphics.vector.ImageVector

// // 'data class' adalah jenis kelas khusus di Kotlin
// // yang tujuannya HANYA untuk "menyimpan data".
// // 'BottomBarItem' adalah nama "cetakan" yang Anda buat.
data class BottomBarItem(
    // // Properti pertama: 'title' (judul)
    // // 'val' berarti nilainya tidak bisa diubah setelah dibuat.
    // // Tipenya adalah 'String' (teks biasa).
    val title: String,

    // // Properti kedua: 'icon' (ikon)
    // // 'val' berarti tidak bisa diubah.
    // // Tipenya adalah 'ImageVector', BUKAN 'Int' atau 'Drawable'.
    // // Ini adalah tipe data khusus Compose untuk ikon.
    val icon: ImageVector
)