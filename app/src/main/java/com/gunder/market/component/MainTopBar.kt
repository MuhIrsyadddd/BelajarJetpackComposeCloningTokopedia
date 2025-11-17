package com.gunder.market.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gunder.market.R
import com.gunder.market.ui.theme.MarketTheme

// @OptIn: Anotasi ini diperlukan karena 'OutlinedTextField'
// dari Material 3 masih dianggap "Eksperimental".
@OptIn(ExperimentalMaterial3Api::class)
// @Composable: Menandakan ini adalah fungsi UI (elemen Composable).
@Composable
fun MainTopBar(modifier: Modifier = Modifier) { // // Mendefinisikan Composable baru bernama MainTopBar

    // --- INI ADALAH STATE (INGATAN) ---
    // 'var searchText': Mendeklarasikan variabel yang bisa berubah.
    // 'by remember': Memberi tahu Compose untuk "mengingat" nilai ini.
    // '{ mutableStateOf("") }': Membuat "wadah" state yang bisa berubah,
    // dengan nilai awalnya adalah teks kosong ("").
    var searchText by remember { mutableStateOf("") }

    // 'Column' menata elemen di dalamnya secara vertikal (dari atas ke bawah).
    Column(modifier = modifier.padding(16.dp)) { // // Memberi padding 16.dp di sekeliling 'Column'

        // 'Row' Pertama: Berisi Search Bar dan ikon-ikon di sebelah kanan.
        Row(
            modifier = Modifier.width(IntrinsicSize.Max), // // Mengatur lebar Row agar pas
            verticalAlignment = Alignment.CenterVertically, // // Menata semua elemen agar rata tengah vertikal.
            horizontalArrangement = Arrangement.spacedBy(8.dp) // // Memberi jarak 8.dp antar elemen.
        ) {
            // 'OutlinedTextField' adalah kotak input teks dengan bingkai.
            OutlinedTextField(
                modifier = Modifier
                    .widthIn(min = 100.dp) // // Lebar minimal 100.dp
                    .padding(start = 8.dp, end = 8.dp), // // Memberi padding di kiri & kanan Search Bar

                // 'value = searchText':
                // Parameter 'value' (nilai) DIHUBUNGKAN ke state 'searchText'.
                // Apa pun isi 'searchText', akan ditampilkan di sini.
                value = searchText,

                // 'onValueChange = { searchText = it }':
                // Ini adalah "pendengar" saat user mengetik.
                // 'it' adalah teks baru yang diketik user.
                // Perintah ini berarti: "UBAH nilai 'searchText' menjadi 'it'".
                // Saat 'searchText' berubah, Compose otomatis menggambar ulang
                // TextField ini dengan 'value' yang baru.
                onValueChange = { searchText = it },

                // 'leadingIcon': Ini adalah 'slot' untuk ikon di DALAM Text Field, di sisi kiri.
                leadingIcon = @androidx.compose.runtime.Composable {
                    Icon(
                        imageVector = Icons.Default.Search, // // Ikon 'Search'
                        contentDescription = null // // Deskripsi untuk aksesibilitas (dikosongkan)
                    )
                },
                // 'placeholder': Teks yg tampil ("Search Here") saat input masih kosong.
                placeholder = { Text(text = "Search Here") }
            )
            // 'Icon' untuk Email
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
                modifier = Modifier.size(23.dp) // // Mengatur ukuran ikon menjadi 23.dp
            )
            // 'Icon' untuk Keranjang Belanja
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                modifier = Modifier.size(23.dp)
            )
            // 'Icon' untuk Notifikasi
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                modifier = Modifier.size(23.dp)
            )
            // 'Icon' untuk Menu
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier.size(23.dp)
            )
        } // // Akhir dari 'Row' pertama

        // 'Row' Kedua: Berisi informasi alamat pengiriman.
        Row(
            modifier = Modifier.padding(top = 8.dp), // // Memberi jarak 8.dp dari 'Row' di atasnya.
            horizontalArrangement = Arrangement.spacedBy(8.dp), // // Memberi jarak 8.dp antar elemen.
            verticalAlignment = Alignment.CenterVertically // // Rata tengah vertikal.
        ) {
            // 'Icon' untuk Lokasi
            Icon(
                imageVector = Icons.Outlined.LocationOn,
                contentDescription = null,
                modifier = Modifier.size(18.dp)) // // Ukuran ikon lebih kecil (18.dp)
            // 'Text' yg mengambil teks dari file resource (res/values/strings.xml)
            Text(text = stringResource(R.string.dikirim_ke_alamat), fontSize = 12.sp) // // Ukuran font 12.sp
            // Teks nama user, dibuat tebal ('FontWeight.Bold')
            Text(text = stringResource(R.string.txt_dummy_user), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            // 'Icon' panah ke bawah
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )

        } // // Akhir dari 'Row' kedua
    } // // Akhir dari 'Column' utama

}


// '@Preview': Anotasi agar Android Studio bisa menampilkan pratinjau Composable ini.
@Preview(showBackground = true)
@Composable
fun MainTopBarPreview() {
    // 'MarketTheme' membungkus pratinjau agar sesuai dgn tema aplikasi (warna, font).
    MarketTheme {
        MainTopBar() // // Memanggil Composable yg ingin kita lihat pratinjaunya.
    }
}