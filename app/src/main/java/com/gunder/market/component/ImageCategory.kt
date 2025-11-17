package com.gunder.market.component

import androidx.compose.foundation.Image // // Impor untuk Composable 'Image' (menampilkan gambar)
import androidx.compose.foundation.layout.Arrangement // // Impor untuk 'Arrangement' (mengatur jarak/spasi antar elemen)
import androidx.compose.foundation.layout.Column // // Impor untuk Composable 'Column' (tata letak vertikal)
import androidx.compose.foundation.layout.Row // // Impor untuk Composable 'Row' (tata letak horizontal)
import androidx.compose.foundation.layout.fillMaxWidth // // Impor untuk modifier '.fillMaxWidth()' (mengisi lebar maksimal)
import androidx.compose.foundation.layout.padding // // Impor untuk modifier '.padding()' (memberi jarak di dalam)
import androidx.compose.foundation.shape.RoundedCornerShape // // Impor untuk membuat bentuk sudut melengkung
import androidx.compose.material3.Card // // Impor untuk Composable 'Card' (kartu, biasanya untuk membungkus konten)
import androidx.compose.runtime.Composable // // Impor 'Composable', anotasi wajib untuk fungsi UI
import androidx.compose.ui.Alignment // // Impor untuk 'Alignment' (mengatur perataan)
import androidx.compose.ui.Modifier // // Impor 'Modifier', untuk memodifikasi (mengubah) Composable
import androidx.compose.ui.res.painterResource // // Impor fungsi untuk memuat gambar dari 'drawable'
import androidx.compose.ui.tooling.preview.Preview // // Impor 'Preview', untuk menampilkan pratinjau di Android Studio
import androidx.compose.ui.unit.dp // // Impor 'dp', satuan ukuran (Density-independent Pixels)
import com.gunder.market.R // // Impor file 'R' (Resource) proyek Anda
import com.gunder.market.ui.theme.MarketTheme // // Impor tema (warna, font) aplikasi Anda

@Composable // // Anotasi: Menandakan ini adalah fungsi UI (elemen Composable)
fun MainImageCategory(modifier: Modifier = Modifier) { // // Mendefinisikan Composable 'MainImageCategory'
    // 'Column' adalah layout utama. Menyusun elemen (dua 'Row') secara vertikal.
    Column(
        // 'modifier = modifier': Menerapkan 'modifier' dari parameter fungsi
        // Ini PENTING: 'modifier' ini (dari luar) akan dipakai oleh SEMUA elemen
        // di bawah yang juga menggunakan 'modifier = modifier'. Ini adalah BUG umum.
        modifier = modifier
            .fillMaxWidth() // // Membuat 'Column' mengisi lebar layar
            .padding(8.dp), // // Memberi jarak 8.dp di sekeliling 'Column'
        verticalArrangement = Arrangement.Center, // // Menyusun dua 'Row' agar rata tengah vertikal
        horizontalAlignment = Alignment.CenterHorizontally // // Menyusun dua 'Row' agar rata tengah horizontal
    ) {
        // 'Row' Pertama: Menampung dua Card/Image pertama secara horizontal
        Row(
            // 'horizontalArrangement': Memberi jarak 16.dp di ANTARA dua 'Card'
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            // PENTING: 'modifier = modifier' di sini menggunakan ulang 'modifier' dari 'Column'.
            // Seharusnya ini 'Modifier.padding(8.dp)' (dengan 'M' besar)
            // agar tidak menimpa modifier dari induknya.
            modifier = modifier.padding(8.dp)
        )  {
            // 'Card': Composable yang memberi efek 'kartu' (sedikit terangkat/berbingkai)
            Card(
                // PENTING: 'modifier = modifier' lagi-lagi menggunakan modifier dari 'Column'
                // Ini akan membuat 'Card' juga .fillMaxWidth() dan .padding(8.dp)
                modifier = modifier,
                // 'shape': Membuat sudut 'Card' melengkung 8.dp
                shape = RoundedCornerShape(8.dp)
            ) {
                // 'Image': Menampilkan gambar di dalam 'Card'
                Image(
                    // 'painterResource': Memuat gambar 'banner_horizontal_1' dari 'drawable'
                    painter = painterResource(id = R.drawable.banner_horizontal_1),
                    contentDescription = "Banner", // // Deskripsi untuk aksesibilitas
                )
            }
            // 'Card' kedua di dalam 'Row' pertama
            Card(
                modifier = modifier, // // PENTING: Bug yang sama, menggunakan 'modifier' induk
                shape = RoundedCornerShape(8.dp) // // Sudut melengkung
            ) {
                // 'Image' kedua
                Image(
                    painter = painterResource(id = R.drawable.banner_horizontal_2),
                    contentDescription = "Banner",
                )
            }
        }
        // 'Row' Kedua: Menampung dua Card/Image terakhir
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp), // // Jarak 16.dp antar 'Card'
            modifier = modifier.padding(8.dp) // // PENTING: Bug yang sama
        )  {
            // 'Card' ketiga
            Card(modifier = modifier, shape = RoundedCornerShape(8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.banner_horizontal_3),
                    contentDescription = "Banner",
                )
            }
            // 'Card' keempat
            Card(modifier = modifier, shape = RoundedCornerShape(8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.banner_horizontal_4),
                    contentDescription = "Banner",
                )
            }
        }
    }
}


@Preview(showBackground = true ) // // Anotasi: Menampilkan pratinjau dengan latar belakang
@Composable // // Anotasi: Fungsi pratinjau juga harus Composable
fun MainCategoryPreview() { // // Fungsi HANYA untuk pratinjau
    MarketTheme { // // Membungkus pratinjau dengan tema aplikasi
        MainImageCategory() // // Memanggil Composable yang ingin kita pratinjau
    }
}