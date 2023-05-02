# Link Shortener API
<p>An API that can shorten any URL.</p>

## Technologies
<ul>
<li>Java EE 17</li>
<li>Spring Boot 2.7.11</li>
<li>Lombok</li>
<li>Spring Boot DevTools</li>
<li>H2 Database</li>
</ul>

## How it works
<p>As an API, you can test it on Insomnia, Postman or any APIs request tool. To shorten an URL, just select the "Form URL Encoded" option, and pass a key-value pair, which "url" is the key, and the URL you want to shorten is the value.</p>
<p>The shortened URL will be returned in the template "http://localhost:8080/{6-digit-HASH}", because the project is running only locally. Though, this local URL will redirect you to the original URL.</p>

## Executing this project
<p>If you have a SSH key:</p>

```sh
git clone git@github.com:marcelofgaraujo/link_shortener.git
```

<p>If you don't:</p>

```sh
git clone https://github.com/marcelofgaraujo/link_shortener.git
```

<p>Then open the project with a Java compatible IDE and run.</p>

## License
<p>This project is under <a href="https://github.com/marcelofgaraujo/link_shortener/blob/main/LICENSE.md">MIT License</a>.</p>
