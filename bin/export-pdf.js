const puppeteer = require('puppeteer');

const convert = async () => {
    const browser = await puppeteer.launch({args: ['--no-sandbox']});
    const page = await browser.newPage();
    await page.goto('file:///Users/ddouglass/src/yaboi/resources/public/index.html', {waitUntil: 'networkidle2'});
    await page.pdf({path: 'resume.pdf', format: 'A4'});
    await browser.close();
};

convert();
