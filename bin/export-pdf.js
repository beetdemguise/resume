const puppeteer = require('puppeteer');

const convert = async () => {
    const browser = await puppeteer.launch({args: ['--no-sandbox']});
    const page = await browser.newPage();
    await page.goto('file:///Users/ddouglass/src/yaboi/resources/public/index.html', {waitUntil: 'networkidle2'});
    await page.emulateMedia('screen');
    await page.pdf({path: 'resume.pdf',
                    printBackground: true,
                    // essentially a slightly shorted A3 format
                    width: '10in',
                    height: '13in'});
    await browser.close();
};

convert();
