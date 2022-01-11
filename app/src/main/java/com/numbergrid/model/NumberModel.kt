package com.numbergrid.model

import android.os.Parcel
import android.os.Parcelable

class NumberModel(var number : Int ,var isEqual : Boolean = false): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(number)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NumberModel> {
        override fun createFromParcel(parcel: Parcel): NumberModel {
            return NumberModel(parcel)
        }

        override fun newArray(size: Int): Array<NumberModel?> {
            return arrayOfNulls(size)
        }
    }
}