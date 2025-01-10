//package com.example.ecommerceapp
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.input.nestedscroll.nestedScroll
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.ecommerceapp.navigation.AppNavigation
//import com.example.ecommerceapp.ui.category.CategoriesScreen
//import com.example.ecommerceapp.ui.delivery.DeliveryScreen
//
//@Preview
//@Composable
//fun PreviewCategoriesScreen() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//        //.verticalScroll(rememberScrollState())
//    ) {
//
//        MainScreenNavigation
//        -  NavHost
//                - Nav graph
//
//
//                        Start destina - *
//        DeliveryScreen()
//        //Spacer(modifier = Modifier.height(4.dp))
//        CategoriesScreen()
//        AppNavigation()
//    }
//}