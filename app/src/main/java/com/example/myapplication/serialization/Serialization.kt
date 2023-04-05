package com.example.myapplication.serialization

import android.os.Parcel
import android.os.Parcelable
import java.io.Externalizable
import java.io.ObjectInput
import java.io.ObjectOutput
import java.io.Serializable

class PersonSerializable(
    val name: String = "name",
    val age: Int = 12
) : Serializable

class PersonParcelable(
    private val name: String = "name",
    private val age: Int = 12
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonParcelable> {
        override fun createFromParcel(parcel: Parcel): PersonParcelable {
            return PersonParcelable(parcel)
        }

        override fun newArray(size: Int): Array<PersonParcelable?> {
            return arrayOfNulls(size)
        }
    }
}

class PersonExternalize(
    val name: String = "name",
    val age: Int = 12
) : Externalizable {

    override fun writeExternal(out: ObjectOutput?) {
    }

    override fun readExternal(`in`: ObjectInput?) {
        TODO("Not yet implemented")
    }
}