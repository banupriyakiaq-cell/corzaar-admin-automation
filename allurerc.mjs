import { defineConfig } from "allure";
 
export default defineConfig({
name: "Corzaar Automation Report",
output: "./AllureReports/report",
 
plugins: {
awesome: {
options: {
singleFile: true,
reportLanguage: "en"
}
}
}
});