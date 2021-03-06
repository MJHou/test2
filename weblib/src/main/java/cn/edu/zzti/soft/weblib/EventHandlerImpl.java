package cn.edu.zzti.soft.weblib;

import android.view.KeyEvent;
import android.webkit.WebView;

/**
 * 事件处理实现
 */

public class EventHandlerImpl implements IEventHandler {
    private WebView mWebView;
    private EventInterceptor mEventInterceptor;

    public static final EventHandlerImpl getInstantce(WebView view,EventInterceptor eventInterceptor) {
        return new EventHandlerImpl(view, eventInterceptor);
    }

    public EventHandlerImpl(WebView webView,EventInterceptor eventInterceptor) {
        LogUtils.i("Info","EventInterceptor:"+eventInterceptor);
        this.mWebView = webView;
        this.mEventInterceptor = eventInterceptor;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return back();
        }
        return false;
    }

    @Override
    public boolean back() {
        if(this.mEventInterceptor!=null&&this.mEventInterceptor.event()){
            return true;
        }
        if(mWebView!=null&&mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }
        return false;
    }

    public void inJectPriorityEvent(){

    }
}
