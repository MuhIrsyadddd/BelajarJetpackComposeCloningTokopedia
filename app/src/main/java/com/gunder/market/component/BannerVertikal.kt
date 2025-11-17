package com.gunder.market.component // // "Alamat" paket tempat file ini berada

import androidx.compose.foundation.Image // // Impor Composable 'Image' untuk menampilkan gambar
import androidx.compose.foundation.layout.padding // // Impor modifier '.padding()' untuk memberi jarak
import androidx.compose.foundation.shape.RoundedCornerShape // // Impor untuk membuat bentuk sudut melengkung
import androidx.compose.material3.Card // // Impor Composable 'Card' (Kartu)
import androidx.compose.material3.CardDefaults // // Impor untuk mengakses pengaturan default 'Card', seperti 'cardColors'
import androidx.compose.runtime.Composable // // Impor anotasi '@Composable', wajib untuk fungsi UI
import androidx.compose.ui.Modifier // // Impor 'Modifier' untuk mengubah (memodifikasi) Composable
import androidx.compose.ui.res.painterResource // // Impor fungsi untuk memuat gambar dari folder 'drawable'
import androidx.compose.ui.res.stringResource // // Impor fungsi untuk memuat teks dari file 'strings.xml'
import androidx.compose.ui.tooling.preview.Preview // // Impor anotasi '@Preview' untuk pratinjau
import androidx.compose.ui.unit.dp // // Impor 'dp', satuan ukuran (Density-independent Pixels)
import com.gunder.market.R // // Impor file 'R' (Resource) proyek Anda (untuk akses ke drawable, string)
import com.gunder.market.model.ListBanner // // Impor data class 'ListBanner' (tampaknya tidak terpakai di file ini)
import com.gunder.market.model.ListCardForYou // // Impor data class 'ListCardForYou' (ini yang dipakai)
import com.gunder.market.ui.theme.MarketTheme // // Impor tema (warna, font) aplikasi Anda
import androidx.compose.ui.graphics.Color // // Impor objek 'Color' (INI YANG ANDA PERBAIKI)

@Composable // // Anotasi: Menandakan ini adalah fungsi UI (elemen Composable)
// // Mendefinisikan Composable 'MainBannerVertical'
// // 'modifier': Parameter agar bisa diatur dari luar
// // 'listBanner: ListCardForYou': Parameter DATA, berisi info gambar & teks
fun MainBannerVertical(modifier: Modifier = Modifier, listBanner: ListCardForYou) {
    // 'Card': Composable yang membungkus konten dalam sebuah kartu
    Card(
        // 'modifier = modifier': Menerapkan 'modifier' dari parameter (jika ada)
        modifier = modifier.padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 8.dp), // // Memberi padding (jarak) di sekeliling 'Card'
        // 'shape': Mengatur bentuk 'Card'
        shape = RoundedCornerShape(8.dp), // // Membuat sudut 'Card' melengkung 8.dp
        // 'colors': Mengatur warna 'Card'
        // 'containerColor = Color.Transparent': Membuat warna latar belakang 'Card' menjadi transparan
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) { // // Kurung '{' ini adalah 'slot' konten, tempat isi 'Card' diletakkan
        // 'Image': Menampilkan gambar di dalam 'Card'
        Image(
            // 'painterResource': Memuat gambar dari 'drawable'
            // 'id = listBanner.imgCard': ID gambar diambil dari objek 'listBanner' (data)
            painter = painterResource(id = listBanner.imgCard ),
            // 'contentDescription': Teks deskripsi untuk aksesibilitas (dibaca screen reader)
            // 'stringResource(id = listBanner.txtDesc)': ID teks diambil dari 'listBanner' (data)
            contentDescription = stringResource(id = listBanner.txtDesc)
        )
    } // // Akhir dari konten 'Card'
}

@Preview(showBackground = true) // // Anotasi: Tampilkan pratinjau Composable ini di Android Studio
@Composable // // Anotasi: Fungsi pratinjau juga harus Composable
fun MainBannerVerticalPreview() { // // Fungsi ini HANYA untuk pratinjau
    MarketTheme { // // Membungkus pratinjau dengan tema aplikasi (agar warna, font sesuai)
        // Memanggil Composable 'MainBannerVertical' yang ingin kita pratinjau
        MainBannerVertical(
            // 'listBanner = ...': Memberikan data "dummy" (contoh)
            // agar pratinjau bisa menampilkan sesuatu
            listBanner = ListCardForYou(R.drawable.banner_vertikal1, R.string.txt_desc_first_banner)
        )
    }
}