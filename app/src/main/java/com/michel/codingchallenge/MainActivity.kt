package com.michel.codingchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.michel.codingchallenge.model.Item
import com.michel.codingchallenge.widget.Adapter

class MainActivity : AppCompatActivity() {

    /*
    For the sake of simplicity the items have been created here but a better solution would be
    Implementing a ViewModel that would provide the items as an StateFlow as well as handle item selection
     */
    private val adapter by lazy {
        Adapter(
            listOf(
                Item("One", "One's description"),
                Item("Two", "Two's description"),
                Item("Three", "Three's description"),
                Item("Four", "Four's description")
            ),
            ::onItemSelected
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupList()
    }

    private fun setupList() {
        val layoutManager = LinearLayoutManager(baseContext)
        val recyclerView: RecyclerView = findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        recyclerView.addItemDecoration(
            DividerItemDecoration(recyclerView.context, layoutManager.orientation)
        )
        recyclerView.adapter = adapter
    }

    private fun onItemSelected(item: Item) {
        Toast.makeText(baseContext, item.title, Toast.LENGTH_LONG).show()
    }
}
