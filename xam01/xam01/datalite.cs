using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Android.Database.Sqlite;

namespace xam01
{
    [Activity(Label = "datalite")]
    public class datalite : Activity
    {
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.datalite);

            Console.WriteLine("Starting activity datalite");

            CreateDatabase();

            FindViewById<Button>(Resource.Id.data_add_btn).Click += BtnAdd_Click;
            FindViewById<Button>(Resource.Id.data_edit_btn).Click += BtnEdit_Click;
        }

        protected SQLiteDatabase dbLite { get; set;  }

        public void CreateDatabase()
        {
            //dbLite = SQLiteDatabase.OpenOrCreateDatabase("xam01-lite.db", null);
            //var sSQLQuery = "CREATE TABLE IF NOT EXISTS People " +
            //            "(_id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR, Dept VARCHAR, Age INT, Country VARCHAR, Phone VARCHAR); ";
            //dbLite.ExecSQL(sSQLQuery);
            //Console.WriteLine("New database is created.");
        }

        private void BtnAdd_Click(object sender, EventArgs e)
        {
            var name = FindViewById<EditText>(Resource.Id.data_edit_name).Text;
            var dept = FindViewById<EditText>(Resource.Id.data_edit_dept).Text;
            //Console.WriteLine("button add clicked with name: {0} and dept {1}", name, dept);
            //ContentValues values = new ContentValues();
            //values.Put("Name", name);
            //values.Put("Dept", dept);
            //values.Put("Country", "India");
            //dbLite.Insert("People", null, values);
            //Console.WriteLine("successfully added entries to sqllite database");
        }

        private void BtnEdit_Click(object sender, EventArgs e)
        {

        }
    }
}