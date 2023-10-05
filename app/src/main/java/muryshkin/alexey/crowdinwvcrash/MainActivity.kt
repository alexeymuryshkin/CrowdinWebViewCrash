package muryshkin.alexey.crowdinwvcrash

import android.content.Context
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.BaseContextWrappingDelegate
import com.crowdin.platform.Crowdin
import muryshkin.alexey.crowdinwvcrash.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    override fun getDelegate() = BaseContextWrappingDelegate(super.getDelegate())

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(
            newBase?.let {
                Crowdin.wrapContext(it)
            }
        )
    }

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.apply {
            settings.apply {
                domStorageEnabled = true
                setSupportZoom(true)
                builtInZoomControls = true
                displayZoomControls = false
                allowFileAccess = true
                useWideViewPort = true
                loadWithOverviewMode = true
            }

            isHorizontalScrollBarEnabled = false
            isFocusable = true

            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()

            loadUrl("https://en.wikipedia.org/wiki/Google")
        }
    }

}