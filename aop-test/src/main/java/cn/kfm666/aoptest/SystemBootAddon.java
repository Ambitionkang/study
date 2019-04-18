package cn.kfm666.aoptest;

import org.springframework.core.Ordered;

public interface SystemBootAddon extends Ordered {
    void onReady();
}
