package com.example.projetoplanetas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PlanetaAdapter.OnItemClickPlanetListener {


    private var planetSelected: Planeta?=null
    private var drawerToogle: ActionBarDrawerToggle?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        left_drawer.adapter= PlanetaAdapter(this, this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawerToogle= object : ActionBarDrawerToggle(this, drawer_layout, R.string.drawer_open, R.string.drawer_close){
            override fun onDrawerOpened(drawerView: View) {
                setTitle("Escolha um planeta")
                invalidateOptionsMenu()
            }

            override fun onDrawerClosed(drawerView: View) {
                if(planetSelected!=null){
                    setTitle(planetSelected?.name)
                }else{
                    setTitle(R.string.app_name)
                }
                invalidateOptionsMenu()
            }
        }
        drawer_layout.addDrawerListener(drawerToogle!!)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(drawerToogle?.onOptionsItemSelected(item)!!){
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        var drawerOpen = drawer_layout.isDrawerOpen(left_drawer)
        var searchMenu : MenuItem = menu?.findItem(R.id.actionSearch)!!
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToogle?.syncState()
    }

    private fun selectedItem(planet: Planeta?){
        if(planet!=null){
            this.planetSelected = planet
            val fragment = PlanetFragment.newInstance(planet)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.content_frame, fragment)
            transaction.commit()
            setTitle(planet.name)
        }
        drawer_layout.closeDrawer(left_drawer!!)
    }

    override fun onClick(planet: Planeta) {
        selectedItem(planet)
    }
}
