package br.com.gilsouza.androidarchitetctures.mvp;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.gilsouza.androidarchitetctures.model.CountriesService;
import br.com.gilsouza.androidarchitetctures.model.Country;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesPresenter {

    private View view;
    private CountriesService service;

    public CountriesPresenter(View view) {
        this.view = view;
        service = new CountriesService();
        fetchCountries();
    }

    private void fetchCountries() {
        service.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Country>>() {
                    @Override
                    public void onSuccess(List<Country> value) {
                        List<String> countryNames = new ArrayList<>();
                        Log.d("UPA", "onSuccess: " + countryNames.size());
                        for (Country country : value) {
                            countryNames.add(country.countryName);
                        }
                        view.setValues(countryNames);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError();
                    }
                });
    }

    public void onRefresh() {
        fetchCountries();
    }

    public interface View {
        void setValues(List<String> countries);
        void onError();
    }

}
