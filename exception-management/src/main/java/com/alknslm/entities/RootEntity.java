package com.alknslm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @param <T> Generic data gelebilecek şekilde tasarım
 *           Gönderilecek response için sabit bir dataclass dönmek üzere yazıldı
 *           Eğer hata varsa result->false // errorMessage-> dolu
 *           Eğer hata yoksa result->true // data->dolu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RootEntity<T> {

    private boolean result;

    private String errorMessage;

    private T data;

    /**
     * @param data
     * @param <T>
     *     bu method çağırılmışsa data başarılı bir şekilde gelmiştir.
     *     Methodlar dışarıdan sınıf üzerinden erişim için static olarak tanımlandı
     * @return
     */
    public static <T> RootEntity<T> ok(T data) {
        RootEntity<T> rootEntity = new RootEntity<T>();
        rootEntity.setData(data);
        rootEntity.setResult(true);
        rootEntity.setErrorMessage(null);
        return rootEntity;
    }

    public static <T> RootEntity<T> error(String errorMessage) {
        RootEntity<T> rootEntity = new RootEntity<T>();
        rootEntity.setData(null);
        rootEntity.setErrorMessage(errorMessage);
        rootEntity.setResult(false);
        return rootEntity;
    }
}
