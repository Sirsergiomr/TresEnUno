package com.example.tresenuno

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_navegador.*

class FragmentNavegador : Fragment() {

    private val BASE_URL = "https://google.com"
    private val SEARCH_PATH = "/search?q="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navegador, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {

        }
        button.setOnClickListener(){
            if(webView.canGoBack()){
                webView.goBack()
            }
        }

        button2.setOnClickListener(){
            if(webView.canGoForward()){
                webView.goForward()
            }
        }
        webView.webChromeClient = object : WebChromeClient(){

        }

        webView.webViewClient = object : WebViewClient(){

        }

        val settings : WebSettings = webView.settings
        settings.javaScriptEnabled = true

        webView.loadUrl(BASE_URL)


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {

                query?.let {
                    if(URLUtil.isValidUrl(it)){
                        webView.loadUrl(it)
                    }else{
                        webView.loadUrl("$BASE_URL$SEARCH_PATH$it")
                    }
                }


                return false
            }
        })


    }


 }
