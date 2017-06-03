#include "mainwindow.h"
#include "ui_mainwindow.h"

#include <QPushButton>
#include <QMessageBox>

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_startButton_clicked()
{
    QMessageBox msgBox;
    msgBox.setWindowTitle("Hello");
    msgBox.setText("You Clicked "+ ((QPushButton*)sender())->text());
    msgBox.exec();
}
