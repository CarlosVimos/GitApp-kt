package com.example.vimos.gitapp.common.extension

import android.content.Context
import android.content.pm.PackageManager
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat

/**
 * Created by Vimos on 30/06/2018.
 */

fun Context.getColorCompat(@ColorRes color: Int) = ContextCompat.getColor(this, color)

fun Context.checkIsPermissionGranted(permission: String) =
        ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED

fun Context.areAllPermissionsGranted(vararg permission: String) = permission.all { checkIsPermissionGranted(it) }