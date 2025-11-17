package com.gunder.market

import MainBottomCategory // // Impor Composable 'MainBottomCategory' (kemungkinan dari file lain)
import android.os.Bundle // // Impor standar Android untuk Activity
import androidx.activity.ComponentActivity // // Impor kelas dasar untuk Activity
import androidx.activity.compose.setContent // // Impor KUNCI: Fungsi untuk "menggambar" UI Compose
import androidx.compose.foundation.layout.Column // // Impor Composable 'Column' (tata letak vertikal)
import androidx.compose.foundation.layout.fillMaxSize // // Impor modifier '.fillMaxSize()'
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow // // Impor Composable 'LazyRow' (daftar horizontal efisien)
import androidx.compose.foundation.lazy.items // // Impor fungsi 'items' untuk looping di dalam LazyRow
import androidx.compose.foundation.rememberScrollState // // Impor fungsi untuk "mengingat" posisi scroll
import androidx.compose.foundation.verticalScroll // // Impor modifier '.verticalScroll()'
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme // // Impor tema (warna, font)
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface // // Impor Composable 'Surface' (kanvas dasar UI)
import androidx.compose.runtime.Composable // // Impor anotasi wajib '@Composable'
import androidx.compose.ui.Modifier // // Impor 'Modifier' untuk mengubah Composable
import androidx.compose.ui.tooling.preview.Devices // // Impor untuk Pratinjau (Preview)
import androidx.compose.ui.tooling.preview.Preview // // Impor anotasi '@Preview'
import androidx.compose.ui.unit.dp
import com.gunder.market.component.BottomBar
import com.gunder.market.component.MainBannerVertical // // Impor Composable 'MainBannerVertical'
import com.gunder.market.component.MainCardCategory // // Impor Composable 'MainCardCategory' dari file component
import com.gunder.market.component.MainImageCategory // // Impor Composable 'MainImageCategory' dari file component
import com.gunder.market.component.MainTopBar // // Impor Composable 'MainTopBar' dari file component
import com.gunder.market.component.MainTopCategory // // Impor Composable 'MainTopCategory' dari file component
import com.gunder.market.component.TopMenu // // Impor Composable 'TopMenu' (cetakan untuk 1 item menu)
import com.gunder.market.model.dummyListBanner // // Impor data dummy (contoh) untuk banner
import com.gunder.market.model.dummyListBottomCategory // // Impor data dummy untuk kategori bawah
import com.gunder.market.model.dummyListCardForYou // // Impor data dummy untuk banner vertikal
import com.gunder.market.model.dummyListTopCategory // // Impor data dummy untuk kategori atas
import com.gunder.market.model.dummyListTopMenus // // Impor data dummy untuk menu atas (Gopay, dll)
import com.gunder.market.ui.theme.MarketTheme // // Impor tema aplikasi Anda

class MainActivity : ComponentActivity() { // // Kelas Activity utama (layar) Anda
    override fun onCreate(savedInstanceState: Bundle?) { // // Fungsi yg dipanggil pertama kali saat Activity dibuat
        super.onCreate(savedInstanceState)
        // 'setContent' adalah jembatan yang memberitahu aplikasi
        // untuk menggambar UI menggunakan Jetpack Compose.
        setContent {
            MarketTheme { // // Menerapkan tema aplikasi (warna, font) ke seluruh UI
                // 'Surface' adalah "kanvas" dasar dgn warna background dari tema
                Surface(
                    modifier = Modifier.fillMaxSize(), // // Mengisi seluruh ukuran layar
                    color = MaterialTheme.colorScheme.background // // Mengambil warna background dari tema
                ) {
                    MarketApp() // // Memanggil Composable utama aplikasi kita
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable // // Anotasi: Menandakan 'MarketApp' adalah fungsi UI
fun MarketApp(modifier: Modifier = Modifier) {
    Scaffold(bottomBar = {BottomBar()}) { paddingValues ->
        Column(
            modifier = modifier
                // 'verticalScroll' membuat 'Column' ini bisa di-scroll ke atas/bawah
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)// // 'rememberScrollState' untuk menyimpan posisi scroll
        ) {

            // --- INI ADALAH SUSUNAN LAYAR ANDA (dari atas ke bawah) ---

            // 1. Memanggil/Menampilkan Composable MainTopBar (Search bar, ikon, dll)
            MainTopBar()

            // 2. Memanggil/Menampilkan Composable MainTopMenu (Gopay, Plus, Rewards)
            MainTopMenu()

            // 3. Memanggil/Menampilkan Composable MainCategoryTop (daftar kategori teratas)
            MainCategoryTop()

            // 4. Memanggil/Menampilkan Composable MainCategoryCard (daftar banner horizontal)
            MainCategoryCard()

            // 5. Memanggil/Menampilkan Composable MainCategoryBottom (daftar kategori bawah)
            MainCategoryBottom()

            // 6. Memanggil/Menampilkan Composable MainImageCategory (4 gambar banner statis)
            MainImageCategory()

            // 7. Memanggil/Menampilkan Composable MainVerticalBanner (daftar banner vertikal)
            MainVerticalBanner()


            // (Anda bisa menambahkan lebih banyak Composable di sini,
            //  dan mereka akan muncul di bagian bawah)
        }
    }
    // 'Column' adalah layout utama aplikasi Anda.
    // Semua elemen di dalamnya akan disusun secara vertikal (dari atas ke bawah).

}

// --- FUNGSI-FUNGSI UNTUK MERANGKAI DAFTAR (LIST) ---
// Ini adalah praktik yang bagus: membuat Composable "perantara"
// yang tugasnya hanya mengatur data dan 'LazyRow'.

@Composable
fun MainTopMenu(modifier: Modifier = Modifier) { // // Composable untuk daftar menu atas
    // 'LazyRow' adalah Composable khusus untuk daftar horizontal YANG BISA DI-SCROLL.
    // Disebut "Lazy" (Malas) karena ia hanya menggambar item yang
    // terlihat di layar, sehingga sangat efisien.
    LazyRow(modifier = modifier) { // // Menerapkan modifier (jika ada) ke LazyRow

        // 'items(dummyListTopMenus)' adalah "looping" khusus untuk Lazy Composable.
        // Ini akan mengulang blok '{...}' untuk setiap item di dalam 'dummyListTopMenus'.
        items(dummyListTopMenus){ item -> // // 'item' adalah nama variabel untuk setiap data (bisa juga 'it')

            // Di dalam loop, kita panggil 'TopMenu' (Composable "cetakan" yg kita buat di file lain)
            // 'listTopMenu = item': Kita "melempar" data 'item' saat ini
            // ke dalam parameter 'listTopMenu' di Composable 'TopMenu'.
            TopMenu(listTopMenu = item)
        }
    }
}

@Composable
fun MainCategoryTop(modifier: Modifier = Modifier) { // // Composable untuk daftar kategori atas
    LazyRow(modifier = modifier) { // // Membuat daftar horizontal yang efisien
        // 'items(dummyListTopCategory)': Looping data dummy kategori atas
        items(dummyListTopCategory){ // // 'it' adalah nama default untuk item di dalam loop
            // 'MainTopCategory': Composable "cetakan" untuk 1 item kategori
            // 'listTopCategory = it': Melempar data item ke dalam Composable
            MainTopCategory(listTopCategory = it)
        }
    }
}

@Composable
fun MainCategoryBottom(modifier: Modifier = Modifier) { // // Composable untuk daftar kategori bawah
    LazyRow(modifier = modifier) { // // Membuat daftar horizontal yang efisien
        // 'items(dummyListBottomCategory)': Looping data dummy kategori bawah
        items(dummyListBottomCategory) { // // 'it' adalah item saat ini
            // 'MainBottomCategory': Composable "cetakan" untuk 1 item
            MainBottomCategory(listBottomCategory = it) // // Melempar data item ke Composable
        }
    }
}

@Composable
fun MainCategoryCard(modifier: Modifier = Modifier) { // // Composable untuk daftar banner horizontal
    LazyRow(modifier = modifier) { // // Membuat daftar horizontal yang efisien
        // 'items(dummyListBanner)': Looping data dummy banner
        items(dummyListBanner){ // // 'it' adalah item saat ini
            // 'MainCardCategory': Composable "cetakan" untuk 1 banner
            MainCardCategory(listBanner = it) // // Melempar data item ke Composable
        }
    }
}


@Composable
fun MainVerticalBanner(modifier: Modifier = Modifier) { // // Composable untuk daftar banner vertikal
    LazyRow(modifier = modifier) { // // Membuat daftar horizontal yang efisien
        // 'items(dummyListCardForYou)': Looping data dummy banner vertikal
        items(dummyListCardForYou){ // // 'it' adalah item saat ini
            // 'MainBannerVertical': Composable "cetakan" untuk 1 banner vertikal
            MainBannerVertical(listBanner = it) // // Melempar data item ke Composable
        }
    }
}


// --- BAGIAN PRATINJAU (PREVIEW) ---
// Semua fungsi di bawah ini HANYA untuk menampilkan pratinjau di Android Studio
// Mereka tidak akan muncul di aplikasi Anda yang sudah jadi (production).

@Preview(showBackground = true) // // Tampilkan pratinjau dengan latar belakang
@Composable
fun MainVerticalBannerPreview() { // // Pratinjau HANYA untuk 'MainVerticalBanner'
    MarketTheme {
        MainVerticalBanner()
    }
}




@Preview(device = Devices.DEFAULT, showBackground = true)
@Composable
fun MainCategoryCardPreview() { // // Pratinjau HANYA untuk 'MainCategoryCard'
    MarketTheme {
        MainCategoryCard()
    }
}


@Preview(device = Devices.DEFAULT, showBackground = true)
@Composable
fun MainCategoryBottomPreview() { // // Pratinjau HANYA untuk 'MainCategoryBottom'
    MarketTheme {
        MainCategoryBottom()
    }

}



@Preview(device = Devices.DEFAULT, showBackground = true)
@Composable
fun MainCategoryTopPreview() { // // Pratinjau HANYA untuk 'MainCategoryTop'
    MarketTheme {
        MainCategoryTop()
    }

}



// Pratinjau HANYA untuk 'MainTopMenu'
@Preview(device = Devices.DEFAULT, showBackground = true)
@Composable
fun MainTopMenuPreview() {
    MarketTheme {
        MainTopMenu() // // Memanggil 'MainTopMenu' untuk pratinjau
    }
}



// Pratinjau untuk seluruh 'MarketApp'
@Preview(device = Devices.DEFAULT, showBackground = true)
@Composable
fun MarketAppPreview() { // // Pratinjau untuk KESELURUHAN layar aplikasi
    MarketTheme {
        MarketApp() // // Memanggil 'MarketApp' untuk pratinjau
    }
}