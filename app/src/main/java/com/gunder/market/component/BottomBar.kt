package com.gunder.market.component

import androidx.compose.material.icons.Icons // // Impor untuk mengakses ikon-ikon Material bawaan
import androidx.compose.material.icons.filled.Home // // Impor ikon 'Home'
import androidx.compose.material.icons.filled.Notifications // // Impor ikon 'Notifications'
import androidx.compose.material.icons.filled.Person // // Impor ikon 'Person'
import androidx.compose.material.icons.filled.ShoppingCart // // Impor ikon 'ShoppingCart'
import androidx.compose.material3.Icon // // Impor Composable 'Icon' (untuk menampilkan ikon)
import androidx.compose.material3.NavigationBar // // Impor Composable 'NavigationBar' (wadah/container untuk bottom bar)
import androidx.compose.material3.NavigationBarItem // // Impor Composable 'NavigationBarItem' (item yang bisa diklik di dalam bar)
import androidx.compose.material3.Text // // Impor Composable 'Text' (untuk menampilkan teks)
import androidx.compose.runtime.Composable // // Impor anotasi '@Composable', wajib untuk fungsi UI
import androidx.compose.ui.Modifier // // Impor 'Modifier' untuk mengubah (memodifikasi) Composable
import androidx.compose.ui.res.stringResource // // Impor fungsi untuk memuat teks dari 'strings.xml'
import androidx.compose.ui.tooling.preview.Preview // // Impor anotasi '@Preview' untuk pratinjau
import com.gunder.market.R // // Impor file 'R' (Resource) proyek Anda
import com.gunder.market.model.BottomBarItem // // Impor 'data class' (model) 'BottomBarItem'
import com.gunder.market.ui.theme.MarketTheme // // Impor tema (warna, font) aplikasi Anda

@Composable // // Anotasi: Menandakan ini adalah fungsi UI (elemen Composable)
fun BottomBar(modifier: Modifier = Modifier) { // // Mendefinisikan Composable 'BottomBar'
    // 'NavigationBar' adalah "wadah" (container) dari Material 3
    // yang akan menampung item-item navigasi di bagian bawah.
    NavigationBar(modifier) { // // 'modifier' dari parameter diterapkan ke wadah ini

        // --- BAGIAN DATA ---
        // 'val bottomNavigation': Membuat sebuah 'List' (daftar)
        // yang berisi DATA (model) untuk setiap item yang ingin ditampilkan.
        // Ini BELUM UI, ini baru datanya. Kita menggunakan 'data class' BottomBarItem.
        val bottomNavigation = listOf(
            BottomBarItem( // // Data untuk item pertama
                title = stringResource(R.string.txt_home), // // Mengambil teks "Home" dari strings.xml
                icon = Icons.Default.Home // // Menggunakan ikon 'Home' bawaan
            ),
            BottomBarItem( // // Data untuk item kedua
                title = stringResource(R.string.txt_home), // // (Seharusnya ini R.string.txt_cart atau yg lain)
                icon = Icons.Default.ShoppingCart
            ),
            BottomBarItem( // // Data untuk item ketiga
                title = stringResource(R.string.txt_home), // // (Seharusnya ini R.string.txt_notifications atau yg lain)
                icon = Icons.Default.Notifications
            ),
            BottomBarItem( // // Data untuk item keempat
                title = stringResource(R.string.txt_home), // // (Seharusnya ini R.string.txt_profile atau yg lain)
                icon = Icons.Default.Person
            )
        )

        // --- BAGIAN UI (RENDER) ---
        // 'bottomNavigation.map': Ini adalah "looping".
        // Perintah ini akan mengulang blok '{...}' untuk SETIAP item
        // yang ada di dalam 'bottomNavigation' (daftar data di atas).
        bottomNavigation.map {
            // 'it' adalah variabel default yang merujuk ke item saat ini
            // (misal: 'BottomBarItem' untuk Home, lalu 'BottomBarItem' untuk ShoppingCart, dst.)

            // 'NavigationBarItem' adalah Composable UI yang SEBENARNYA.
            // Ini adalah tombol yang bisa diklik di dalam 'NavigationBar'.
            NavigationBarItem(
                // 'selected': Parameter untuk menentukan apakah item ini "aktif" (terpilih).
                // KODE INI BERARTI: "Item ini terpilih JIKA judulnya SAMA DENGAN
                // judul item PERTAMA (indeks 0) di daftar."
                // Ini akan membuat 'Home' selalu terpilih (hardcoded).
                selected = it.title == bottomNavigation[0].title,

                // 'onClick': Apa yang terjadi saat item ini diklik.
                // '{ }' berarti "tidak melakukan apa-apa" saat diklik.
                // (Di aplikasi nyata, ini akan mengubah 'state' item yang terpilih)
                onClick = {  },

                // 'icon': Ini adalah "slot" (area) untuk menaruh Composable ikon.
                // '{ Icon(...) }' adalah lambda yang berisi Composable 'Icon'.
                icon = { Icon(imageVector = it.icon, contentDescription = it.title) },

                // 'label': Ini adalah "slot" untuk menaruh Composable teks/label.
                label = {Text(it.title)} // // Menampilkan teks (title) dari item data
            )
        }
    }
}


@Preview // // Anotasi: Menampilkan pratinjau Composable ini di Android Studio
@Composable // // Anotasi: Fungsi pratinjau juga harus Composable
fun BottomBarPreview() { // // Fungsi ini HANYA untuk pratinjau
    MarketTheme { // // Membungkus pratinjau dengan tema aplikasi
        BottomBar() // // Memanggil Composable yang ingin kita pratinjau
    }
}