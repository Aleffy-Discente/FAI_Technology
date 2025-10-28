package com.example.fai_technology.ui.viewmodel

import androidx.lifecycle.*
import com.example.fai_technology.data.model.DogImage
import com.example.fai_technology.data.repository.EnergyRepository
import kotlinx.coroutines.launch

class EnergyViewModel : ViewModel() {

    private val repository = EnergyRepository()

    private val _dogImage = MutableLiveData<DogImage?>()
    val dogImage: LiveData<DogImage?> get() = _dogImage

    fun loadRandomImage() {
        viewModelScope.launch {
            val image = repository.fetchRandomDogImage()
            _dogImage.postValue(image)
        }
    }
}