package com.pemmob.h1d024040

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pemmob.h1d024040.ui.screen.DaftarProdukScreen
import com.pemmob.h1d024040.ui.screen.DetailProductScreen
import com.pemmob.h1d024040.ui.screen.HubungiKamiScreen
import com.pemmob.h1d024040.ui.theme.JualanTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JualanTheme {
                // Inisialisasi pengontrol navigasi
                val navController = rememberNavController()

                // NavHost sebagai wadah yang mengatur perpindahan antar layar
                NavHost(navController = navController, startDestination = "daftar_produk") {

                    // Rute 1: Layar Utama (Daftar Produk)
                    composable(route = "daftar_produk") {
                        DaftarProdukScreen(navController = navController)
                    }

                    // Rute 2: Layar Hubungi Kami
                    composable(route = "hubungi_kami") {
                        HubungiKamiScreen(navController = navController)
                    }

                    // Rute 3: Layar Detail Produk (Menerima parameter ID Produk)
                    composable(
                        route = "detail/{productId}",
                        arguments = listOf(navArgument(name = "productId") {
                            type = NavType.IntType
                        })
                    ) { backStackEntry ->
                        // Mengambil angka ID yang dikirim dari DaftarProdukScreen
                        val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                        DetailProductScreen(
                            productId = productId,
                            navController = navController
                        )
                    }

                }
            }
        }
    }
}