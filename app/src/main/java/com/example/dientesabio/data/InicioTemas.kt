package com.example.dientesabio.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InicioTemas (
    val id:  Int,
    val nombre:  String,
    val descripcion: String,
    val imagen: Int

): Parcelable


