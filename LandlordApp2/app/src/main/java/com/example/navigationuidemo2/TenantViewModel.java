package com.example.navigationuidemo2;

import androidx.lifecycle.*

class TenantViewModel: ViewModel() {
    private val _tenantInfo = MutableLiveData<String>("")
            val tenantInfo: LiveData<String> = _tenantInfo
            fun addTenant(name: String, unit: String, rent: String){
        val newEntry = "Name: $name\nUnit: $unit\nRent:\n\n"
                _tenantInfo.value = (_tenantInfo.value ?:"") + newEntry
    }
}
