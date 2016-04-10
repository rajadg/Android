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

namespace xam01
{
    [Activity(Label = "prompts")]
    public class prompts : Activity
    {
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            // Create your application here
            SetContentView(Resource.Layout.prompts);

            Button btnAlert = FindViewById<Button>(Resource.Id.btnBasicAlert);
            btnAlert.Click += delegate { System.Console.WriteLine("clicked alert button");  };

            Button btnPrompt = FindViewById<Button>(Resource.Id.btnBasicPrompt);
            btnPrompt.Click += BtnPrompt_Click;

        }

        private void BtnPrompt_Click(object sender, EventArgs e)
        {
            System.Console.WriteLine("Clicked on basic prompt button");
            //Page.DisplayAlert("Question?", "Would you like to play a game", "Yes", "No");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.SetTitle("Question");
            builder.SetPositiveButton("Ok", 
                (senderAlert, args) => {
                    Console.WriteLine("ok clicked");
                });
            builder.Create().Show();
        }

    }
}