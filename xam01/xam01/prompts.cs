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
            btnAlert.Click += BtnAlert_Click;

            Button btnPrompt = FindViewById<Button>(Resource.Id.btnBasicPrompt);
            btnPrompt.Click += BtnPrompt_Click;

        }

        private void BtnAlert_Click(object sender, EventArgs e)
        {
            System.Console.WriteLine("Clicked on alert button");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.SetTitle("Information");
            builder.SetMessage("Sample alert message");
            builder.SetPositiveButton("Ok",
                (senderAlert, args) => {
                    Console.WriteLine("ok clicked");
                });
            builder.Create().Show();
        }

        private void BtnPrompt_Click(object sender, EventArgs e)
        {
            System.Console.WriteLine("Clicked on basic prompt button");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.SetTitle("Please Confirm");
            builder.SetMessage("Are you sure you want to continue ?");
            builder.SetPositiveButton("Yes",
                (senderAlert, args) => {
                    Console.WriteLine("Yes clicked");
                });
            builder.SetNegativeButton("No",
                (senderAlert, args) => {
                    Console.WriteLine("No clicked");
                });
            builder.Create().Show();
        }

    }
}