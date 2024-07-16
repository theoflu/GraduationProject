const express = require('express');
const app = express();
const pool = require('./db'); //

app.use(express.urlencoded());

app.post("/auth", async function (req, res) {
  console.log(req.body);
  const streamername=req.body.name
  const streamkey = req.body.key; // Değişiklik burada
  try {
    
    const result = await pool.query('SELECT * FROM users WHERE streamkey = $1', [streamkey]);
    // console.log(result[0].u_name);
    
    if(streamername===result[0].u_name) {
      // console.log(streamkey);
      if (result.length> 0) {
        await pool.query('UPDATE users SET is_live = true WHERE streamkey = $1', [streamkey]);
        res.status(200).send();
        return;
      }
    }

    res.status(403).send('Invalid stream key');
  } catch (error) {
    console.error('Error fetching data from database:', error);
    res.status(500).send('Internal server error'); 
  }
});

app.post("/stop", async function (req, res) {
  console.log(req.body);
  const streamkey = req.body.key;

  try {
    await pool.query('UPDATE users SET is_live = false WHERE streamkey = $1', [streamkey]);

    res.status(200).send('Stream stopped successfully');
  } catch (error) {
    console.error('Error updating data in database:', error);
    res.status(500).send('Internal server error'); 
  }
});

app.listen(8000, function () {
  console.log("Listening on port 8000!");
});