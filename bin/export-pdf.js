const puppeteer = require('puppeteer');
const path = require('path');

const html_file = path.join(__dirname, "..", "index.html")

console.log(`Rendering ${html_file}`)

const convert = async () => {
    const browser = await puppeteer.launch({args: ['--no-sandbox']});
    const page = await browser.newPage();
    await page.goto(`file://${html_file}`, {waitUntil: 'networkidle2'});
    await page.emulateMedia('screen');
    await page.pdf({path: 'resume.pdf',
                    printBackground: true,
                    // essentially a slightly shorted A3 format
                    width: '10in',
                    height: '13in'});
    await browser.close();
};

convert();
