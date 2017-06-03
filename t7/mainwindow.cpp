#include "mainwindow.h"
#include "ui_mainwindow.h"
#include "manager.cpp"

#include <QPushButton>
#include <QMessageBox>

using namespace std;
MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    // the initial state of panel
    start(false);
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_startButton_clicked()
{
    QString text = ui->field->text();
    ui->field->setText("");
    if (text.isEmpty()) {
        showMessage("Digite um valor no campo");
    } else {
        int intValue = text.toInt();
        start(true);
        // just initialize the manager.
        Manager::getInstance().start(intValue);
    }
}

void MainWindow::start(bool flag) {
    winners = 0;
    ui->lblWinner->setText("");
    ui->resetButton->setEnabled(flag);
    ui->sortButton->setEnabled(flag);
    ui->startButton->setEnabled(!flag);
    ui->winnerInView->setText("");
}

void MainWindow::on_resetButton_clicked()
{
    start(false);
    ui->field->setText("");
}

void MainWindow::on_sortButton_clicked()
{
    int guess = Manager::getInstance().getGuess();
    if (guess == NO_PARTICIPANTS) {
        start(false);
        showMessage("Todos os participantes já foram sorteados");
    } else {
        string win = to_string(++winners) + "º Ganhador";
        ui->lblWinner->setText(QString::fromStdString(win));
        string stdString = to_string(guess);
        ui->winnerInView->setText(QString::fromStdString(stdString));
    }
}

void MainWindow::showMessage(string text) {
    QMessageBox msgBox;
    msgBox.setWindowTitle("Mensagem");
    msgBox.setText(QString::fromStdString(text));
    msgBox.exec();
}
