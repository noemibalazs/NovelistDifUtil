package com.example.novelistdifutil

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.novelistdifutil.adapter.NovelAdapter
import com.example.novelistdifutil.data.Novelist
import com.example.novelistdifutil.repo.DummyNovelist
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: NovelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateUI()
    }

    private fun onNovelClicked(novelist: Novelist) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.apply {
            setData(Uri.parse(novelist.link))
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun populateUI() {
        mainRecycler.setHasFixedSize(true)
        adapter = NovelAdapter(DummyNovelist().myList, this::onNovelClicked)
        mainRecycler.adapter = adapter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_year -> {
                adapter.replaceOldNew(DummyNovelist().afterYears)
                true
            }
            R.id.menu_novel -> {
                adapter.replaceOldNew(DummyNovelist().afterNovel)
                true
            }
            R.id.menu_name -> {
                adapter.replaceOldNew(DummyNovelist().afterName)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

