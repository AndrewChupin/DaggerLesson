package com.example.core.utils;


import android.support.v7.util.DiffUtil;

import java.util.List;


public class DiffUtils {

    public static <T> void calculateDuffs(List<T> oldList, List<T> newList, Function<DiffUtil.DiffResult> function) {
        BaseDiffUtils<T> baseDiffUtils = new BaseDiffUtils<>(oldList, newList);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(baseDiffUtils, false);
        function.apply(result);
    }

}