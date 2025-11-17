package com.gunder.market.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gunder.market.R
import com.gunder.market.model.ListTopMenu
import com.gunder.market.ui.theme.MarketTheme

// @Composable: Menandakan ini adalah fungsi UI (elemen Composable)
@Composable
// Ini adalah definisi fungsi 'TopMenu' Anda.
// 'modifier: Modifier = Modifier' adalah parameter standar agar Composable ini bisa diatur dari luar.
// 'listTopMenu: ListTopMenu' adalah parameter DATA. Ini berisi data (gambar, teks) yang ingin ditampilkan.
fun TopMenu(modifier: Modifier = Modifier, listTopMenu: ListTopMenu) {
    // 'Row' adalah Composable layout. Ini menyusun elemen di dalamnya secara horizontal (ke samping).
    Row(
        // 'modifier = modifier': Menerapkan 'modifier' yang diberikan saat 'TopMenu' dipanggil.
        // Ini memungkinkan 'TopMenu' diatur ukurannya, padding-nya, dll, dari luar.
        modifier = modifier
            .padding(8.dp) // // Memberi padding 8.dp di sekeliling 'Row'.
            // 'height(IntrinsicSize.Max)': Membuat 'Row' memiliki tinggi SETINGGI elemen anak tertingginya.
            // Dalam kasus ini, 'Image' (48.dp) adalah yang tertinggi, jadi 'Row' akan setinggi 48.dp.
            .height(IntrinsicSize.Max),
        // 'horizontalArrangement': Mengatur jarak antar elemen di dalam 'Row'.
        // 'spacedBy(8.dp)' secara otomatis memberi jarak 8.dp di antara 'Image', 'Column', dan 'Divider'.
        horizontalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        // 'Image': Menampilkan gambar.
        Image(
            // 'painterResource': Memuat gambar dari folder 'drawable'.
            // 'id = listTopMenu.imgTopBar': ID gambar diambil dari objek 'listTopMenu' yang kita terima.
            painter = painterResource(id = listTopMenu.imgTopBar),
            contentDescription = null, // // Deskripsi untuk aksesibilitas (dikosongkan untuk ikon dekoratif).

            // !! PERBAIKAN PENTING !!
            // Anda sebelumnya menulis 'modifier.size(48.dp)'.
            // Itu salah, karena 'modifier' (huruf kecil) merujuk ke parameter fungsi.
            // Yang benar adalah 'Modifier' (huruf besar) untuk membuat Modifier baru.
            modifier = Modifier.size(48.dp) // // Mengatur ukuran 'Image' menjadi 48.dp x 48.dp.
        )
        // 'Column': Menyusun elemen di dalamnya secara vertikal (ke bawah).
        Column {
            // 'Text': Menampilkan teks.
            // 'stringResource': Memuat teks dari file 'strings.xml'.
            // 'id = listTopMenu.txtTopBar': ID teks diambil dari objek 'listTopMenu'.
            Text(text = stringResource(id = listTopMenu.txtTopBar), fontSize = 16.sp)
            // 'Text' kedua untuk deskripsi.
            Text(
                text = stringResource(id = listTopMenu.descTopBar), // // Mengambil teks deskripsi
                fontWeight = FontWeight.Bold, // // Membuat teks menjadi tebal
                fontSize = 14.sp // // Mengatur ukuran font
            )
        }
        // 'Divider': Menampilkan garis pemisah vertikal.
        Divider(
            // 'Modifier' untuk 'Divider'
            modifier = Modifier
                .width(1.dp) // // Mengatur ketebalan garis menjadi 1.dp
                // !! REKOMENDASI PERBAIKAN !!
                // 'height(40.dp)' akan membuat garis lebih pendek dari 'Image' (48.dp).
                // 'fillMaxHeight()' jauh lebih baik karena akan membuat 'Divider'
                // mengisi tinggi 'Row' secara otomatis (berkat 'IntrinsicSize.Max' di atas).
                .fillMaxHeight() // // Mengganti '.height(40.dp)'
        )

    }
}


// '@Preview': Anotasi agar Android Studio bisa menampilkan pratinjau Composable ini.
@Preview(showBackground = true)
@Composable
fun TopMenuPreview() {
    // 'MarketTheme' membungkus pratinjau agar sesuai dgn tema aplikasi (warna, font).
    MarketTheme {
        Row {
            TopMenu(
                listTopMenu = ListTopMenu(
                    imgTopBar = R.drawable.gopay,
                    txtTopBar = R.string.txt_dummy_gopay,
                    descTopBar = R.string.txt_dummy_gopay
                )
            )

            // Panggilan KEDUA untuk Plus
            TopMenu(
                listTopMenu = ListTopMenu(
                    imgTopBar = R.drawable.plus,
                    txtTopBar = R.string.txt_dummy_discount,
                    descTopBar = R.string.txt_subscription
                )
            )
            // Panggil Ketiga untuk Reqard
            TopMenu(
                listTopMenu = ListTopMenu(
                    imgTopBar = R.drawable.rewards,
                    txtTopBar = R.string.txt_dummy_rewards,
                    descTopBar = R.string.txt_dummy_rewards
                )
            )
        }
        // Memanggil Composable 'TopMenu' untuk ditampilkan di pratinjau.
    }
}