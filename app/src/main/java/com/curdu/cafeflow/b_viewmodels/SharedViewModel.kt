package com.curdu.cafeflow.b_viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curdu.cafeflow.c_models.entitats.Comanda
import com.curdu.cafeflow.c_models.entitats.Producte
import com.curdu.cafeflow.c_models.entitats.Usuari
import com.curdu.cafeflow.c_models.repositoris.ComandesRepositori
import com.curdu.cafeflow.c_models.repositoris.HistorialRepositori

class SharedViewModel : ViewModel() {

    private var _usuariActiu: MutableLiveData<Usuari?> = MutableLiveData(null)
    val usuarActiu : LiveData<Usuari?>
        get() = _usuariActiu

    private var _llistatProductes: MutableLiveData<MutableList<Producte>> = MutableLiveData(mutableListOf<Producte>())
    val llistatProductes: LiveData<List<Producte>>
        get() = _llistatProductes as LiveData<List<Producte>>

    private var _preuTotal : MutableLiveData<Double> = MutableLiveData(0.0)
    val preuTotal : LiveData<Double>
        get() = _preuTotal


    fun setUsuari(usuari : Usuari) {
        this._usuariActiu.value = usuari
    }

    fun afegirProducte(producte: Producte) {
        this._llistatProductes.value!!.add(producte)
        this._preuTotal.value = this._preuTotal.value?.plus(producte.preu)
    }

    fun eliminarProducte(producte: Producte) {
        this._llistatProductes.value!!.remove(producte)
        this._preuTotal.value = this._preuTotal.value?.minus(producte.preu)
    }

    suspend fun pagarComanda(context: Context) {
        val preuTotal = _llistatProductes.value!!.map { it.preu }.reduce { acc, d -> acc+d }
        val comanda = Comanda(0, preuTotal, _usuariActiu.value!!.nom)

        ComandesRepositori.afegirComanda(context,comanda )
        HistorialRepositori.afegirComandaHistorial(comanda)
        this._llistatProductes.postValue(mutableListOf())
        this._preuTotal.postValue(0.0)
    }
}